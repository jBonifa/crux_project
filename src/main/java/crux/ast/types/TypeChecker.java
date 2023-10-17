package crux.ast.types;

import crux.ast.SymbolTable.Symbol;
import crux.ast.*;
import crux.ast.traversal.NullNodeVisitor;
import crux.ir.insts.BinaryOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class will associate types with the AST nodes from Stage 2
 */
public final class TypeChecker {
  private final ArrayList<String> errors = new ArrayList<>();

  public ArrayList<String> getErrors() {
    return errors;
  }

  public void check(DeclarationList ast) {
    var inferenceVisitor = new TypeInferenceVisitor();
    inferenceVisitor.visit(ast);
  }

  /**
   * Helper function, should be used to add error into the errors array
   */
  private void addTypeError(Node n, String message) {
    errors.add(String.format("TypeError%s[%s]", n.getPosition(), message));
  }

  /**
   * Helper function, should be used to record Types if the Type is an ErrorType then it will call
   * addTypeError
   */
  private void setNodeType(Node n, Type ty) {
    ((BaseNode) n).setType(ty);
    if (ty.getClass() == ErrorType.class) {
      var error = (ErrorType) ty;
      addTypeError(n, error.getMessage());
    }
  }

  /**
   * Helper to retrieve Type from the map
   */
  public Type getType(Node n) {
    return ((BaseNode) n).getType();
  }


  /**
   * This calls will visit each AST node and try to resolve it's type with the help of the
   * symbolTable.
   */
  private final class TypeInferenceVisitor extends NullNodeVisitor<Void> {
    @Override
    public Void visit(VarAccess vaccess) {
      //System.out.println("vaccess");
      setNodeType(vaccess, vaccess.getSymbol().getType());
      return null;
    }

    @Override
    public Void visit(ArrayDeclaration arrayDeclaration) {
      //System.out.println("arrayDecl");
      setNodeType(arrayDeclaration, arrayDeclaration.getSymbol().getType());
      return null;
    }

    @Override
    public Void visit(Assignment assignment) {
      //System.out.println("assignment");
      //Expression location, Expression value
      Node n = assignment.getLocation();
      n.accept(this);
      Node n2 = assignment.getValue();
      n2.accept(this);
      Type locaTy = ((BaseNode) n).getType();
      Type resultT = locaTy.assign(((BaseNode) n2).getType());
      setNodeType(assignment, resultT);
      return null;
    }

    @Override
    public Void visit(Break brk) {
      //System.out.println("brk");
      //nothing to do?
      return null;
    }

    @Override
    public Void visit(Call call) {
      //System.out.println("call");
      Type c = call.getCallee().getType(); //FuncType
      TypeList args = new TypeList();
      for (Node n : call.getArguments()) {
        n.accept(this);
        Type t = ((BaseNode) n).getType();
        args.append(t);
      }
      Type RT = c.call(args); //want args to be a TypeList
      setNodeType(call, RT);
      return null;
    }

    @Override
    public Void visit(DeclarationList declarationList) {
      // System.out.println("declList");
      var l = declarationList.getChildren();
      for (Node n : l) {
        n.accept(this);
      }
      return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition) {
      //System.out.println("funcDefn");
      setNodeType(functionDefinition, functionDefinition.getSymbol().getType());
      for (Node n : functionDefinition.getChildren()) {
        n.accept(this);
        if (n.getClass() == Return.class) {
          FuncType FT = (FuncType) functionDefinition.getType();
          //checks func signature for equivalence
          setNodeType(n, FT.getRet().assign(((Return) n).getType()));
        }
      }
      return null;
    }

    @Override
    public Void visit(IfElseBranch ifElseBranch) {
      //System.out.println("ifElse");
      //check that conditions are boolean
      Node n = ifElseBranch.getCondition();
      n.accept(this);
      Type condTy = ((BaseNode) n).getType();
      if ((new BoolType()).equivalent(condTy) != true) {
        condTy = new ErrorType("condition is not boolean");
      }
      setNodeType(ifElseBranch, condTy);
      Node n2 = ifElseBranch.getThenBlock();
      n2.accept(this);
      Node n3 = ifElseBranch.getElseBlock();
      n3.accept(this);
      return null;
    }

    @Override
    public Void visit(ArrayAccess access) {
      Type baseTy = access.getBase().getType();
      Node node = access.getIndex();
      node.accept(this);
      Type offsetTy = ((BaseNode) node).getType();
      Type resultTy = baseTy.index(offsetTy);
      setNodeType(access, resultTy);
      return null;
    }

    @Override
    public Void visit(LiteralBool literalBool) {
      setNodeType(literalBool, new BoolType());
      return null;
    }

    @Override
    public Void visit(LiteralInt literalInt) {
      setNodeType(literalInt, new IntType());
      return null;
    }

    @Override
    public Void visit(For forloop) {
      //System.out.println("forLoop");
      Node init = forloop.getInit();
      init.accept(this);
      Node cond = forloop.getCond();
      cond.accept(this);
      Type condTy = ((BaseNode) cond).getType();
      if ((new BoolType()).equivalent(condTy) != true) {
        condTy = new ErrorType("condition is not boolean");
      }
      setNodeType(forloop, condTy);
      Node in = forloop.getIncrement();
      in.accept(this);
      Node sL = forloop.getBody();
      sL.accept(this);
      return null;
    }

    @Override
    public Void visit(OpExpr op) {
      //System.out.println("op");
      //depedning on op, we do different checks
      OpExpr.Operation operation = op.getOp();
      Node lhs = op.getLeft();
      lhs.accept(this);
      Type lhsTy = ((BaseNode) lhs).getType();
      Node rhs = op.getRight(); //can be null
      Type resultTy = null;
      if (operation == OpExpr.Operation.LOGIC_NOT) {//right doesnt not exist
         resultTy = lhsTy.not();
      }
      else {
        rhs.accept(this);
        Type rhsTy = ((BaseNode) rhs).getType();
        if (operation == OpExpr.Operation.ADD) {resultTy = lhsTy.add(rhsTy); }
        else if (operation == OpExpr.Operation.SUB) {resultTy = lhsTy.sub(rhsTy); }
        else if (operation == OpExpr.Operation.MULT) {resultTy = lhsTy.mul(rhsTy); }
        else if (operation == OpExpr.Operation.DIV) {resultTy = lhsTy.div(rhsTy); }
        else if (operation == OpExpr.Operation.LOGIC_AND) {resultTy = lhsTy.and(rhsTy); }
        else if (operation == OpExpr.Operation.LOGIC_OR) {resultTy = lhsTy.or(rhsTy); }
        else {resultTy = lhsTy.compare(rhsTy); }
      }
      setNodeType(op, resultTy);
      return null;
    }

    @Override
    public Void visit(Return ret) {
      //System.out.println("ret");
      Node n = ret.getValue();
      n.accept(this);
      Type Ty = ((BaseNode) n).getType();
      setNodeType(ret, Ty);
      return null;
    }

    @Override
    public Void visit(StatementList statementList) {
      //System.out.println("statList");
      for (Node n : statementList.getChildren()) {
        n.accept(this);
      }
      return null;
    }

    @Override
    public Void visit(VariableDeclaration variableDeclaration) {
      //System.out.println("varDecl");
      setNodeType(variableDeclaration, variableDeclaration.getSymbol().getType());
      return null;
    }
  }
}
