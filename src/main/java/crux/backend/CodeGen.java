package crux.backend;

import crux.ast.SymbolTable.Symbol;
import crux.ast.types.BoolType;
import crux.ir.*;
import crux.ir.insts.*;
import crux.printing.IRValueFormatter;

import java.util.*;

/**
 * Convert the CFG into Assembly Instructions
 */
public final class CodeGen extends InstVisitor {
  private final Program p;
  private final CodePrinter out;

  private final IRValueFormatter irFormat = new IRValueFormatter();
  private HashMap<Variable, Integer> varIndexMap;
  private int varIndex;

  private int[] labelStart;

  private HashMap<Instruction, String> labels;

  public CodeGen(Program p) {
    this.p = p;
    // Do not change the file name that is outputted or it will
    // break the grader!

    out = new CodePrinter("a.s");
  }

  /**
   * It should allocate space for globals call genCode for each Function
   */
  public void genCode() {
    //TODO
    // FIRST DO GLOBALS
    // THEN DO FUNCTIONS
    labelStart = new int[]{1};
    for (Iterator<GlobalDecl> glob_it = p.getGlobals(); glob_it.hasNext();) {
      GlobalDecl g = glob_it.next(); //global var and arraydecls
      String name = g.getSymbol().getName();
      long i = g.getNumElement().getValue(); //for vars its 1, for arrays its the number of elements
      long size = i * 8;
      out.printCode(".comm " + name + ", " + size + ", 8");
    }

    for (Iterator<Function> func_it = p.getFunctions(); func_it.hasNext();) {
      Function f = func_it.next();
      genCodeFunc(f);
    }
    out.close();
  }

  public void genCodeFunc(Function f) {
    //1. assign labels for jump targets
    labels = f.assignLabels(labelStart);
    //2. declare functions and print label
    //out.printCode(".globl " + f.getName()); FOR SUBMIT TING
    out.printCode(".globl " + f.getName());
    //out.printLabel(f.getName() + ":"); FOR SUBMITTING
    out.printLabel(f.getName() + ":");
    //3. generate code for arguments need to know # of arguments
    //  use %rdi, %ris, %rdi, %rsi, %r8, %r9 then stack: -8(%rbp), -16(%rbp) etc
    int numArgs = f.getArguments().size(); // or n
    varIndexMap = new HashMap<>();
    varIndex = 0; //INITAL START OF INDEX
    //4. emit functions prolog
    int numSlots = f.getNumTempVars() + f.getNumTempAddressVars(); //TODO may need to add extra space for args so + numArgs;
    //if (numArgs > 6) numSlots++; //TODO ADDING TO SAVE STACK POINTER
    if (numSlots % 2 == 1) //odd
      numSlots++;
    out.printCode("enter $(8 * " + numSlots + "), $0");
    List<LocalVar> argList = f.getArguments();
    if (numArgs != 0) { //SAVES ARGS IN PROLOG
      if (numArgs >= 1) {
        out.printCode("movq %rdi, -8(%rbp)");
        varIndex += 8;
        varIndexMap.put(argList.get(0), varIndex);
      }
      if (numArgs >= 2) {
        out.printCode("movq %rsi, -16(%rbp)");
        varIndex += 8;
        varIndexMap.put(argList.get(1), varIndex);
      }
      if (numArgs >= 3) {
        out.printCode("movq %rdx, -24(%rbp)");
        varIndex += 8;
        varIndexMap.put(argList.get(2), varIndex);
      }
      if (numArgs >= 4) {
        out.printCode("movq %rcx, -32(%rbp)");
        varIndex += 8;
        varIndexMap.put(argList.get(3), varIndex);
      }
      if (numArgs >= 5) {
        out.printCode("movq %r8, -40(%rbp)");
        varIndex += 8;
        varIndexMap.put(argList.get(4), varIndex);
      }
      if (numArgs >= 6) {
        out.printCode("movq %r9, -48(%rbp)");
        varIndex += 8;
        varIndexMap.put(argList.get(5), varIndex);
      }
      if (numArgs >= 7) {
        //need to save args 7-n from stack
        //going to pull off the stack backwards
        int top = 16 + (8 * (numArgs - 7));
        for (int n = 7; n <= numArgs; n++) {
          varIndex += 8;
          varIndexMap.put(argList.get(n - 1), varIndex);
          int offset2 = 8 * n;
          out.printCode("movq " + top + "(%rbp), %r10");
          out.printCode("movq %r10, -"+offset2+"(%rbp)");
          top -= 8;
        }
      }
    }
    //SAVE STACK POINTER where numArgs == n
    //if (numArgs > 6) {
    //  int offset = numArgs * 8 - 40;
    //  out.printCode("movq " + offset + "(%rbp), %r10");
    //  int temp = numArgs * -8;
    //  out.printCode("movq %r10, " + temp + "(%rbp)");
    //}
    //5. generate instructions for functions body
    //keep track of instructions to visit in a stack
    //keep track of visited instructions in a set to avoid redundant visits
    Stack<Instruction> instructionStack = new Stack<>();
    HashSet<Instruction> visited = new HashSet<>();
    Instruction start = f.getStart();
    instructionStack.add(start);
    while (!instructionStack.isEmpty()) {
      Instruction current = instructionStack.pop();
      if (visited.contains(current)) {
        //if instruction has already been visited, jmp to label instead
        out.printCode("jmp "+labels.get(current));
      }
      else {//new instruction
        //we visit current instruciton and push next instructions on the stack
        visited.add(current);
        printInstructionInfo(current);
        //if instruction needs label add a label
        if (labels.containsKey(current)) {
          out.printLabel(labels.get(current) + ":");
        }
        current.accept(this); //generates code for instruction
        int numInsts = current.numNext(); //either 1 or 2
        if (numInsts == 1) {
          instructionStack.add(current.getNext(0));
        } else if (numInsts == 2) {
          instructionStack.add(current.getNext(1));
          instructionStack.add(current.getNext(0));
        } else {//if numInst == 0
          out.printCode("leave");
          out.printCode("ret");
        }
      }
    }
    //6. stack needs to be 16 bytes aligned
    //EPILOGUE
    out.printCode("leave");
    out.printCode("ret");
    //clear globals for function
    varIndexMap = null;
    labels = null;
    varIndex = 0;
  }

  private void printInstructionInfo(Instruction i) {
    var info = String.format("/* %s */", i.format(irFormat));
    out.printCode(info);
  }
  public void visit(AddressAt i) {
    out.printCode("movq "+i.getBase().getName()+"@GOTPCREL(%rip), %r11");
    if (i.getOffset() != null) {
      //load offset into $r10
      out.printCode("movq -"+varIndexMap.get(i.getOffset())+"(%rbp), %r10");
      out.printCode("imulq $8, %r10");
      out.printCode("addq %r10, %r11");
    }

    Variable v = i.getDst();
    int offset;
    if (!varIndexMap.containsKey(v)) {
      varIndex += 8;
      offset = varIndex;
      varIndexMap.put(v, varIndex);
    }
    else {
      offset = varIndexMap.get(v);
    }
    out.printCode("movq %r11, -"+offset+"(%rbp)");


  }

  public void visit(BinaryOperator i) {
    //ADD, SUB, MUL all same on slide 16
    // Op op, LocalVar destVar, LocalVar lhsValue, LocalVar rhsValue) {
    //    super(destVar, List.of(lhsValue, rhsValue)
    //slide 17 for division
    BinaryOperator.Op o = i.getOperator();
    if (o != BinaryOperator.Op.Div) {
      out.printCode("movq -"+varIndexMap.get(i.getLeftOperand())+"(%rbp), %r10");
      if (o == BinaryOperator.Op.Add)
        out.printCode("addq -"+varIndexMap.get(i.getRightOperand())+"(%rbp), %r10");
      else if (o == BinaryOperator.Op.Mul)
        out.printCode("imulq -"+varIndexMap.get(i.getRightOperand())+"(%rbp), %r10");
      else //SUB
        out.printCode("subq -"+varIndexMap.get(i.getRightOperand())+"(%rbp), %r10");
      Variable v = i.getDst();
      int offset;
      if (!varIndexMap.containsKey(v)) {
        varIndex += 8;
        offset = varIndex;
        varIndexMap.put(v, varIndex);
      }
      else {
        offset = varIndexMap.get(v);
      }
      out.printCode("movq %r10, -" + offset + "(%rbp)");
    } else { //DIV
      out.printCode("movq -"+varIndexMap.get(i.getLeftOperand())+"(%rbp), %rax");
      out.printCode("cqto");
      out.printCode("idivq -"+varIndexMap.get(i.getRightOperand())+"(%rbp)");
      Variable v = i.getDst();
      int offset;
      if (!varIndexMap.containsKey(v)) {
        varIndex += 8;
        offset = varIndex;
        varIndexMap.put(v, varIndex);
      }
      else {
        offset = varIndexMap.get(v);
      }
      out.printCode("movq %rax, -" + offset + "(%rbp)");
    }
  }

  public void visit(CompareInst i) {
    //LocalVar destVar, Predicate predicate, LocalVar lhs, LocalVar rhs
    out.printCode("movq $0, %rax");
    out.printCode("movq $1, %r10");
    out.printCode("movq -"+varIndexMap.get(i.getLeftOperand())+"(%rbp), %r11"); //lhs
    out.printCode("cmp -"+varIndexMap.get(i.getRightOperand())+"(%rbp), %r11");//rhs
    CompareInst.Predicate p = i.getPredicate();
    //GE, GT, LE, LT, EQ, NE
    if (p == CompareInst.Predicate.GT) {
      out.printCode("cmovg %r10, %rax");
    } else if (p == CompareInst.Predicate.GE) {
      out.printCode("cmovge %r10, %rax");
    } else if (p == CompareInst.Predicate.LE) {
      out.printCode("cmovle %r10, %rax");
    } else if (p == CompareInst.Predicate.LT) {
      out.printCode("cmovl %r10, %rax");
    } else if (p == CompareInst.Predicate.EQ) {
      out.printCode("cmove %r10, %rax");
    } else { //NE
      out.printCode("cmovne %r10, %rax");
    }

    //dest might be empty
    Variable v = i.getDst();
    int offset;
    if (!varIndexMap.containsKey(v)) {
      varIndex += 8;
      offset = varIndex;
      varIndexMap.put(v, varIndex);
    }
    else {
      offset = varIndexMap.get(v);
    }
    out.printCode("movq %rax, -"+offset+"(%rbp)");
  }

  public void visit(CopyInst i) {
    String reg;
    if (i.getSrcValue().getClass() == BooleanConstant.class) {
      BooleanConstant bC = (BooleanConstant) i.getSrcValue();
      if (bC.getValue() == true) {
        reg = "$1";
      }
      else {
        reg = "$0";
      }
      out.printCode("movq " + reg + ", %r10");
    }
    else if (i.getSrcValue().getClass() == IntegerConstant.class) { //IntegerCo
      IntegerConstant iC = (IntegerConstant) i.getSrcValue();
      reg = "$" + iC.getValue();
      out.printCode("movq " + reg + ", %r10");
    }
    else { //LocalVar
      out.printCode("movq -" + varIndexMap.get((LocalVar)i.getSrcValue()) + "(%rbp), %r10");
    }

    Variable v = i.getDstVar();
    int offset;
    if (!varIndexMap.containsKey(v)) {
      varIndex += 8;
      offset = varIndex;
      varIndexMap.put(v, varIndex);
    }
    else {
      offset = varIndexMap.get(v);
    }
    out.printCode("movq %r10, -" + offset + "(%rbp)");
  }

  public void visit(JumpInst i) {
    out.printCode("movq -"+varIndexMap.get(i.getPredicate())+"(%rbp), %r10");
    out.printCode("cmp $1, %r10");
    //i.getNext(1) is then block
    out.printCode("je "+ labels.get(i.getNext(1)));
  }

  public void visit(LoadInst i) {
    Variable v = i.getSrcAddress();
    int offset;
    if (!varIndexMap.containsKey(v)) {
      varIndex += 8;
      offset = varIndex;
      varIndexMap.put(v, varIndex);
    }
    else {
      offset = varIndexMap.get(v);
    }
    out.printCode("movq -"+offset+"(%rbp), %r10");
    out.printCode("movq 0(%r10), %r10");
    v = i.getDst();
    if (!varIndexMap.containsKey(v)) {
      varIndex += 8;
      offset = varIndex;
      varIndexMap.put(v, varIndex);
    }
    else {
      offset = varIndexMap.get(v);
    }
    out.printCode("movq %r10, -"+offset+"(%rbp)");
  }

  public void visit(NopInst i) {
  }

  public void visit(StoreInst i) {
    Variable v = i.getSrcValue();
    int offset;
    if (!varIndexMap.containsKey(v)) {
      varIndex += 8;
      offset = varIndex;
      varIndexMap.put(v, varIndex);
    }
    else {
      offset = varIndexMap.get(v);
    }
    out.printCode("movq -"+offset+"(%rbp), %r10");
    v = i.getDestAddress();
    if (!varIndexMap.containsKey(v)) {
      varIndex += 8;
      offset = varIndex;
      varIndexMap.put(v, varIndex);
    }
    else {
      offset = varIndexMap.get(v);
    }
    out.printCode("movq -"+offset+"(%rbp), %r11");
    out.printCode("movq %r10, 0(%r11)");
  }

  public void visit(ReturnInst i) {
    if (i.getReturnValue() != null) {
      out.printCode("movq -" + varIndexMap.get(i.getReturnValue()) + "(%rbp), %rax");
    }
    out.printCode("leave");
    out.printCode("ret");
  }

  public void visit(CallInst i) {
    //movq all args to appropriate locations
    List<LocalVar> argList = i.getParams();
    int numArgs = argList.size();
    if (numArgs != 0) { //saves params to arg
      if (numArgs >= 1) { //rdi
        out.printCode("movq -"+varIndexMap.get(argList.get(0))+"(%rbp), %rdi");
      }
      if (numArgs >= 2) { //rsi
        out.printCode("movq -"+varIndexMap.get(argList.get(1))+"(%rbp), %rsi");
      }
      if (numArgs >= 3) { //rdx
        out.printCode("movq -"+varIndexMap.get(argList.get(2))+"(%rbp), %rdx");
      }
      if (numArgs >= 4) { //rcx
        out.printCode("movq -"+varIndexMap.get(argList.get(3))+"(%rbp), %rcx");
      }
      if (numArgs >= 5) { // r8
        out.printCode("movq -"+varIndexMap.get(argList.get(4))+"(%rbp), %r8");
      }
      if (numArgs >= 6) { // r9
        out.printCode("movq -"+varIndexMap.get(argList.get(5))+"(%rbp), %r9");
      }
      if (numArgs >= 7) {
        //need to save args 7-n from stack in reverse order WRONG
        int offset = 0;
        for (int n = numArgs; n >= 7; n--) { //0, 8, 16
          out.printCode("movq -"+varIndexMap.get(argList.get(n-1))+"(%rbp), %r10");
          out.printCode("movq %r10, "+offset+"(%rsp)"); //CHANGING TO SEE IF IT WORKS
          offset += 8; //-= 8;
        }
      }
    }
    //call func
    out.printCode("call "+i.getCallee().getName());
    // if func is not void, then move %rax to the stack
    if (i.getDst() != null) {
      Variable v = i.getDst();
      int offset;
      if (!varIndexMap.containsKey(v)) {
        varIndex += 8;
        offset = varIndex;
        varIndexMap.put(v, varIndex);
      }
      else {
        offset = varIndexMap.get(v);
      }
      out.printCode("movq %rax, -"+offset+"(%rbp)");
    }


  }

  public void visit(UnaryNotInst i) {
    out.printCode("movq $1, %r11");
    Variable v = i.getDst();
    int offset;
    if (!varIndexMap.containsKey(v)) {
      varIndex += 8;
      offset = varIndex;
      varIndexMap.put(v, varIndex);
    }
    else {
      offset = varIndexMap.get(v);
    }
    out.printCode("subq %r11, -"+offset+"(%rbp)");
  }
}
