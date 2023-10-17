package crux.ir;

import crux.ast.SymbolTable.Symbol;
import crux.ast.*;
import crux.ast.OpExpr.Operation;
import crux.ast.traversal.NodeVisitor;
import crux.ast.types.*;
import crux.ir.insts.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class InstPair {
  Instruction start;
  Instruction end;
  Value val;
  InstPair(Instruction start, Instruction end, Value val) {
    this.start = start;
    this.end = end;
    this.val = val;
  }

  Instruction getStart() {
    return start;
  }

  Instruction getEnd() {
    return end;
  }

  Value getVal() {
    return val;
  }
}


/**
 * Convert AST to IR and build the CFG
 */
public final class ASTLower implements NodeVisitor<InstPair> {
  private Program mCurrentProgram = null;
  private Function mCurrentFunction = null;

  private Map<Symbol, LocalVar> mCurrentLocalVarMap = null;

  //FOR LOOPS
  private ArrayList<Instruction> mCurrentForLoopList = new ArrayList<>();

  /**
   * A constructor to initialize member variables
   */
  public ASTLower() {}

  public Program lower(DeclarationList ast) {
    visit(ast);
    return mCurrentProgram;
  }

  @Override
  public InstPair visit(DeclarationList declarationList) {
    //ITERATE THRU DECL LIST SUPPOSED TO UPDATE mCURRENT PROGRAM
    mCurrentProgram = new Program();
    for (Node n : declarationList.getChildren()) {
      InstPair p = n.accept(this);
    }
    return null;
  }

  /**
   * This visitor should create a Function instance for the functionDefinition node, add parameters
   * to the localVarMap, add the function to the program, and init the function start Instruction.
   */
  @Override
  public InstPair visit(FunctionDefinition functionDefinition) {
    //FROM CLASS:
    // create mCurrentFunction instance
    mCurrentFunction = new Function(functionDefinition.getSymbol().getName(), (FuncType) functionDefinition.getSymbol().getType());
    // create new hashmap<symbol, var> for mCurrent>ocalVarMap
    mCurrentLocalVarMap = new HashMap<>();
    // for each arg
    List<LocalVar> tempList = new ArrayList<>();
    for (Symbol s : functionDefinition.getParameters()) {
      // create localvar using mCurrnetFunction.gettempvar and put them in a list
      LocalVar v = mCurrentFunction.getTempVar(s.getType());
      tempList.add(v);
      // put the var in mCurrentLocalVarpMap with correct sumbol
      mCurrentLocalVarMap.put(s, v);
    }
    // set argments for mCurrentFunction
    mCurrentFunction.setArguments(tempList);
    // add mCurrentFunction to thge function list in mCurrentProgram
    mCurrentProgram.addFunction(mCurrentFunction);
    // visit ufcntion boy
    StatementList sL = functionDefinition.getStatements();
    InstPair p = sL.accept(this);
    // set setart node of mCurrentFunction
    mCurrentFunction.setStart(p.getStart());
    //dump mCurrentFunction and mCurrentLocalVarMap
    mCurrentFunction = null;
    mCurrentLocalVarMap = null;
    return p;
  }

  @Override
  public InstPair visit(StatementList statementList) {
    //start with nopinst
    Instruction start = new NopInst();
    Instruction end = new NopInst();
    //for each statment
    InstPair current = null;
    //System.out.println(3);
    //System.out.println(start);

    for (Node n : statementList.getChildren()) {
      //visit and connect them
      InstPair p = n.accept(this);
      //System.out.println(p);
      //System.out.println(p.getStart());
      //System.out.println(p.getEnd());
      //System.out.println(p.getVal());
      if (current == null)
        start.setNext(0, p.getStart());
      else {//connecting end of current to beginning of p
        current.getEnd().setNext(0, p.getStart());
      }
      current = p;
    }

    if (current != null) {
      current.getEnd().setNext(0, end);
    }
    else {
      return new InstPair(start, start, null);
    }

    //System.out.println(start);
    //System.out.println(start.getNext(0));
    //System.out.println(start.getNext(1).getNext(0));
    //return InstPair with start and end of statment LIst, with no vallue for InstPair
    return new InstPair(start, end, null);
  }

  /**
   * Declarations, could be either local or Global
   */
  @Override
  public InstPair visit(VariableDeclaration variableDeclaration) {
    NopInst i = new NopInst();
    if (mCurrentFunction == null) {
      //its a global, add gloval var to mCurrentPorgram
      Symbol s = variableDeclaration.getSymbol();
      IntegerConstant iC = IntegerConstant.get(mCurrentProgram, 1); // for one variable
      mCurrentProgram.addGlobalVar(new GlobalDecl(s, iC));
      return new InstPair(i, i, null);
    }
    //its a local, alloate tempvar to mCureentLocalVarMap
    LocalVar v = mCurrentFunction.getTempVar(variableDeclaration.getSymbol().getType());
    mCurrentLocalVarMap.put(variableDeclaration.getSymbol(), v);
    return new InstPair(i, i, null);
  }

  /**
   * Create a declaration for array and connected it to the CFG
   */
  @Override
  public InstPair visit(ArrayDeclaration arrayDeclaration) {
    //DOESNT NEED TO RETURN INSTPAIR so give nop or null
    //all array declsare are global so create and add goval decl
    Symbol s = arrayDeclaration.getSymbol();
    ArrayType a = (ArrayType) s.getType();
    IntegerConstant iC = IntegerConstant.get(mCurrentProgram, a.getExtent());
    mCurrentProgram.addGlobalVar(new GlobalDecl(s, iC));
    NopInst i = new NopInst();
    return new InstPair(i, i, null);
  }

  /**
   * LookUp the name in the map(s). For globals, we should do a load to get the value to load into a
   * LocalVar.
   */
  @Override
  public InstPair visit(VarAccess name) {
    if (mCurrentLocalVarMap.containsKey(name.getSymbol())) {
      NopInst i = new NopInst();
      return new InstPair(i, i, mCurrentLocalVarMap.get(name.getSymbol()));
    }
    //global
    //create temp addressvar and addressat inst to store address to global var
    AddressVar aV = mCurrentFunction.getTempAddressVar(name.getType());
    AddressAt aA = new AddressAt(aV, name.getSymbol());
    return new InstPair(aA, aA, aV);
  }

  /**
   * If the location is a VarAccess to a LocalVar, copy the value to it. If the location is a
   * VarAccess to a global, store the value. If the location is ArrayAccess, store the value.
   */
  @Override
  public InstPair visit(Assignment assignment) {
    List<Node> l = assignment.getChildren(); //0 is left 1 is right
    Node lhs = l.get(0);
    Node rhs = l.get(1);
    InstPair left = lhs.accept(this);
    InstPair right = rhs.accept(this);
    left.getEnd().setNext(0, right.getStart());
    //37
    //if left is local, use copyinst
    //else use storeinst for global
    if (left.getVal().getClass() == AddressVar.class) {
      //global var
      LocalVar v = null;
      LoadInst i = null;
      if (right.getVal().getClass() == AddressVar.class) {
        v = mCurrentFunction.getTempVar(right.getVal().getType());
        i = new LoadInst(v, (AddressVar) right.getVal());
      }
      else v = (LocalVar) right.getVal();
      StoreInst sI = new StoreInst(v, (AddressVar) left.getVal());
      //right.getEnd().setNext(0, sI);
      if (i == null) right.getEnd().setNext(0, sI);
      else {
        right.getEnd().setNext(0, i);
        i.setNext(0, sI);
      }
      return new InstPair(left.getStart(), sI, null);
    }
    //local var
    //
    LocalVar v = null;
    LoadInst i = null;
    if (right.getVal().getClass() == AddressVar.class) {
      v = mCurrentFunction.getTempVar(right.getVal().getType());
      i = new LoadInst(v, (AddressVar) right.getVal());
    }
    else v = (LocalVar) right.getVal();
    //
    CopyInst cI = new CopyInst((LocalVar) left.getVal(), v);
    if (i == null) right.getEnd().setNext(0, cI);
    else {
      right.getEnd().setNext(0, i);
      i.setNext(0, cI);
    }
    //right.getEnd().setNext(0, cI);
    return new InstPair(left.getStart(), cI, null);
  }

  /**
   * Lower a Call.
   */
  @Override
  public InstPair visit(Call call) {
    //visit each arg to construct CFG and add a localVar containing the arg valeu to the param list
    List<LocalVar> l = new ArrayList<>();
    Instruction start = new NopInst();
    InstPair current = null;

    for (Node n : call.getChildren()) {
      InstPair p = n.accept(this);
      LocalVar v = mCurrentFunction.getTempVar(p.getVal().getType());
      Instruction i = null;
      if (p.getVal().getClass() == AddressVar.class) {
        i = new LoadInst(v, (AddressVar) p.getVal());
      }
      else
        i = new CopyInst(v, p.getVal());
      InstPair p2 = new InstPair(i, i, v);
      l.add(v);
      //connects addressAt to argument
      p.getEnd().setNext(0, p2.getStart());
      if (current == null)
        start.setNext(0, p.getStart());
      else //connecting end of current to beginning of p2
        current.getEnd().setNext(0, p.getStart());
      current = p2;
    }
    //if function is not void, create a temp var fo rthe return and pass that as the INstPairs value
    //construct call INst
    FuncType t = (FuncType) call.getCallee().getType();
    CallInst cI = null;
    LocalVar r = null;
    if (t.getRet().getClass() == VoidType.class)
      cI = new CallInst(call.getCallee(), l);
    else {
      r = mCurrentFunction.getTempVar(t.getRet());
      cI = new CallInst(r, call.getCallee(), l);
    }
    //39 min
    //conecting current to callinst
    if (current != null)
      current.getEnd().setNext(0, cI);
    else start.setNext(0, cI);
    return new InstPair(start, cI, r);
  }

  /**
   * Handle operations like arithmetics and comparisons. Also handle logical operations (and,
   * or, not).
   */
  @Override
  public InstPair visit(OpExpr operation) {
    List<Node> children = operation.getChildren();
    InstPair left = children.get(0).accept(this);
    //
    Instruction leftConnection = left.getEnd();
    LocalVar lefty;
    LoadInst leftSI = null;
    if (left.getVal().getClass() == AddressVar.class) {
      lefty = mCurrentFunction.getTempVar(left.getVal().getType());
      leftSI = new LoadInst(lefty, (AddressVar) left.getVal());
    }
    else lefty = (LocalVar) left.getVal();
    if (leftSI != null) {
      left.getEnd().setNext(0, leftSI);
      leftConnection = leftSI;
    }
    //
    if (operation.getOp() == Operation.LOGIC_NOT) {
      LocalVar v = mCurrentFunction.getTempVar(left.getVal().getType());
      UnaryNotInst i = new UnaryNotInst(v, lefty);
      leftConnection.setNext(0, i);
      return new InstPair(left.getStart(), i, v);
    }
    else {
      InstPair right = children.get(1).accept(this);
      if (operation.getOp() == Operation.ADD
              || operation.getOp() == Operation.SUB
              || operation.getOp() == Operation.MULT
              || operation.getOp() == Operation.DIV ){
        LocalVar v = mCurrentFunction.getTempVar(left.getVal().getType());
        leftConnection.setNext(0, right.getStart());
        BinaryOperator.Op o;
        if (operation.getOp() == Operation.ADD) o = BinaryOperator.Op.Add;
        else if (operation.getOp() == Operation.SUB) o = BinaryOperator.Op.Sub;
        else if (operation.getOp() == Operation.MULT) o = BinaryOperator.Op.Mul;
        else o = BinaryOperator.Op.Div;

        LocalVar rightt;
        LoadInst rightSI = null;
        if (right.getVal().getClass() == AddressVar.class) {
          rightt = mCurrentFunction.getTempVar(right.getVal().getType());
          rightSI = new LoadInst(rightt, (AddressVar) right.getVal());
        }
        else rightt = (LocalVar) right.getVal();

        BinaryOperator i = new BinaryOperator(o, v, lefty, rightt);
        if (rightSI == null){
          right.getEnd().setNext(0, i);
        } else if (rightSI != null) {
          right.getEnd().setNext(0, rightSI);
          rightSI.setNext(0, i);
        }
        //right.getEnd().setNext(0, i);
        return new InstPair(left.getStart(), i, v);
      }
      else if (operation.getOp() == Operation.GE
              || operation.getOp() == Operation.GT
              || operation.getOp() == Operation.LE
              || operation.getOp() == Operation.LT
              || operation.getOp() == Operation.EQ
              || operation.getOp() == Operation.NE) {
        LocalVar v = mCurrentFunction.getTempVar(new BoolType());
        leftConnection.setNext(0, right.getStart());
        CompareInst.Predicate o;
        if (operation.getOp() == Operation.GE) o = CompareInst.Predicate.GE;
        else if (operation.getOp() == Operation.GT) o = CompareInst.Predicate.GT;
        else if (operation.getOp() == Operation.LE) o = CompareInst.Predicate.LE;
        else if (operation.getOp() == Operation.LT) o = CompareInst.Predicate.LT;
        else if (operation.getOp() == Operation.EQ) o = CompareInst.Predicate.EQ;
        else o = CompareInst.Predicate.NE;

        LocalVar rightt;
        LoadInst rightSI = null;

        if (right.getVal().getClass() == AddressVar.class) {
          rightt = mCurrentFunction.getTempVar(right.getVal().getType());
          rightSI = new LoadInst(rightt, (AddressVar) right.getVal());
        }
        else rightt = (LocalVar) right.getVal();

        CompareInst i = new CompareInst(v, o, lefty, rightt);

        if (rightSI == null){
          right.getEnd().setNext(0, i);
        } else if (rightSI != null) {
          right.getEnd().setNext(0, rightSI);
          rightSI.setNext(0, i);
        }
        return new InstPair(left.getStart(), i, v);
      }
      else if (operation.getOp() == Operation.LOGIC_OR){
        //left and right are the instpairs
        JumpInst j = new JumpInst(lefty);
        leftConnection.setNext(0, j);
        j.setNext(0, right.getStart());
        LocalVar v1 = mCurrentFunction.getTempVar(new BoolType());
        CopyInst c1 = new CopyInst(v1, right.getVal());
        right.getEnd().setNext(0, c1);
        NopInst n = new NopInst();
        c1.setNext(0, n);
        CopyInst c2 = new CopyInst(v1, BooleanConstant.get(mCurrentProgram, true));
        j.setNext(1, c2);
        c2.setNext(0, n);
        return new InstPair(left.getStart(), n, v1);
      }
      else {//AND
        JumpInst j = new JumpInst(lefty);
        leftConnection.setNext(0, j);
        LocalVar v1 = mCurrentFunction.getTempVar(new BoolType());
        CopyInst c2 = new CopyInst(v1, BooleanConstant.get(mCurrentProgram, false));
        j.setNext(0, c2);
        NopInst n = new NopInst();
        c2.setNext(0, n);
        j.setNext(1, right.getStart());
        CopyInst c1 = new CopyInst(v1, right.getVal());
        right.getEnd().setNext(0, c1);
        c1.setNext(0, n);
        return new InstPair(left.getStart(), n, v1);
      }
    }
  }

  private InstPair visit(Expression expression) {
    return null;
  }

  /**
   * It should compute the address into the array, do the load, and return the value in a LocalVar.
   */
  @Override
  public InstPair visit(ArrayAccess access) {
    InstPair p = access.getIndex().accept(this);
    AddressVar aV = mCurrentFunction.getTempAddressVar(access.getType());
    LocalVar v = null;
    LoadInst i = null;
    if (p.getVal().getClass() == AddressVar.class) {
      v = mCurrentFunction.getTempVar(p.getVal().getType());
      i = new LoadInst(v, (AddressVar) p.getVal());
    }
    else v = (LocalVar) p.getVal();
    AddressAt aA = new AddressAt(aV, access.getBase(), v);
    if (i == null) p.getEnd().setNext(0, aA);
    else {
      p.getEnd().setNext(0, i);
      i.setNext(0, aA);
    }
    return new InstPair(p.getStart(), aA, aV);
  }

  /**
   * Copy the literal into a tempVar
   */
  @Override
  public InstPair visit(LiteralBool literalBool) {
    LocalVar v = mCurrentFunction.getTempVar(literalBool.getType());
    BooleanConstant bC = BooleanConstant.get(mCurrentProgram, literalBool.getValue());
    CopyInst cI = new CopyInst(v, bC);
    return new InstPair(cI, cI, v);
  }

  /**
   * Copy the literal into a tempVar
   */
  @Override
  public InstPair visit(LiteralInt literalInt) {
    LocalVar v = mCurrentFunction.getTempVar(literalInt.getType());
    IntegerConstant iC = IntegerConstant.get(mCurrentProgram, literalInt.getValue());
    CopyInst cI = new CopyInst(v, iC);
    return new InstPair(cI, cI, v);
  }

  /**
   * Lower a Return.
   */
  @Override
  public InstPair visit(Return ret) {
    InstPair p = ret.getValue().accept(this);
    ReturnInst rI = new ReturnInst((LocalVar) p.getVal());
    p.getEnd().setNext(0, rI);
    return new InstPair(p.getStart(), rI, null);
  }

  /**
   * Break Node
   */
  @Override
  public InstPair visit(Break brk) {
    return new InstPair(mCurrentForLoopList.get(0), mCurrentForLoopList.get(0), null);
  }

  /**
   * Implement If Then Else statements.
   */
  @Override
  public InstPair visit(IfElseBranch ifElseBranch) {
    InstPair cond = ifElseBranch.getCondition().accept(this);
    JumpInst j = new JumpInst((LocalVar) cond.getVal());
    cond.getEnd().setNext(0, j);
    InstPair elseBlock = ifElseBranch.getElseBlock().accept(this);
    j.setNext(0, elseBlock.getStart());
    InstPair thenBlock = ifElseBranch.getThenBlock().accept(this);
    j.setNext(1, thenBlock.getStart());
    NopInst n = new NopInst();
    elseBlock.getEnd().setNext(0, n);
    thenBlock.getEnd().setNext(0, n);
    return new InstPair(cond.getStart(), n, null);
  }

  /**
   * Implement for loops.
   */
  @Override
  public InstPair visit(For loop) {
    //mCurrentForLoopList is for saving loop exits send to the beginning of the loop
    //first INITALIZE which points to COND
    //THEN DO COND -> JUMP
    //THEN JUMP -> EXIT OR BODY
    //THEN DO THE BODY ->
    //THEN DO THE INCREMENT -> COND AGAIN
    InstPair initialize = loop.getInit().accept(this);
    InstPair cond = loop.getCond().accept(this);
    initialize.getEnd().setNext(0, cond.getStart());
    JumpInst j = new JumpInst((LocalVar) cond.getVal());
    cond.getEnd().setNext(0, j);
    NopInst exit = new NopInst();
    mCurrentForLoopList.add(0, exit);
    j.setNext(0, exit);
    InstPair body = loop.getBody().accept(this);
    j.setNext(1, body.getStart());
    InstPair in = loop.getIncrement().accept(this);
    body.getEnd().setNext(0, in.getStart());
    in.getEnd().setNext(0, cond.getStart());
    mCurrentForLoopList.remove(0);
    //CHANGING
    return new InstPair(initialize.getStart(), exit, null);
  }
}
