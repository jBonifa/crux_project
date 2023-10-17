package crux.ast;

import com.sun.jdi.CharType;
import crux.ast.Position;
import crux.ast.types.*;


import java.io.PrintStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Symbol table will map each symbol from Crux source code to its declaration or appearance in the
 * source. The symbol table is made up of scopes, Each scope is a map which maps an identifier to
 * it's symbol. Scopes are inserted to the table starting from the first scope (Global Scope). The
 * Global scope is the first scope in each Crux program and it contains all the built in functions
 * and names. The symbol table is an ArrayList of scops.
 */
public final class SymbolTable {

  /**
   * Symbol is used to record the name and type of names in the code. Names include function names,
   * global variables, global arrays, and local variables.
   */
  static public final class Symbol implements java.io.Serializable {
    static final long serialVersionUID = 12022L;
    private final String name;
    private final Type type;
    private final String error;

    /**
     *
     * @param name String
     * @param type the Type
     */
    private Symbol(String name, Type type) {
      this.name = name;
      this.type = type;
      this.error = null;
    }

    private Symbol(String name, String error) {
      this.name = name;
      this.type = null;
      this.error = error;
    }

    /**
     *
     * @return String the name
     */
    public String getName() {
      return name;
    }

    /**
     *
     * @return the type
     */
    public Type getType() {
      return type;
    }

    @Override
    public String toString() {
      if (error != null) {
        return String.format("Symbol(%s:%s)", name, error);
      }
      return String.format("Symbol(%s:%s)", name, type);
    }

    public String toString(boolean includeType) {
      if (error != null) {
        return toString();
      }
      return includeType ? toString() : String.format("Symbol(%s)", name);
    }
  }

  private final PrintStream err;
  private final ArrayList<Map<String, Symbol>> symbolScopes = new ArrayList<>();
  private boolean encounteredError = false;
  private int len;

  SymbolTable(PrintStream err) {
    this.err = err;
    symbolScopes.add(new HashMap<String, Symbol>()); //adds first scope
    this.len = 1;
    add(null, "readInt", new FuncType(new TypeList(), new IntType()));
    add(null, "readChar", new FuncType(new TypeList(), new IntType()));
    ArrayList<Type> l = new ArrayList<Type>();
    l.add(new BoolType());
    add(null, "printBool", new FuncType(new TypeList(l), new VoidType()));
    ArrayList<Type> l2 = new ArrayList<Type>();
    l2.add(new IntType());
    add(null, "printInt", new FuncType(new TypeList(l2), new VoidType()));
    ArrayList<Type> l3 = new ArrayList<Type>();
    l3.add(new IntType());
    add(null, "printChar", new FuncType(new TypeList(l3), new VoidType()));
    add(null, "println", new FuncType(new TypeList(), new VoidType()));
  }

  boolean hasEncounteredError() {
    return encounteredError;
  }

  /**
   * Called to tell symbol table we entered a new scope.
   */

  void enter() {
    symbolScopes.add(0, new HashMap<String, Symbol>()); //pushes inner scope to first index
    len++;
  }

  /**
   * Called to tell symbol table we are exiting a scope.
   */

  void exit() {
    if (len > 1) {
      symbolScopes.remove(0);
      len--;
    }

  }

  /**
   * Insert a symbol to the table at the most recent scope. if the name already exists in the
   * current scope that's a declareation error.
   */
  Symbol add(Position pos, String name, Type type) {
    Map<String, Symbol> m = symbolScopes.get(0);
    if (m.containsKey(name)) {
      err.printf("DeclareSymbolError%s[Cannot refine %s.]%n", pos, name);
      encounteredError = true;
      return new Symbol(name, "DeclareSymbolError");
    }
    Symbol s = new Symbol(name, type);
    m.put(name, s);
    return s;
  }

  /**
   * lookup a name in the SymbolTable, if the name not found in the table it shouold encounter an
   * error and return a symbol with ResolveSymbolError error. if the symbol is found then return it.
   */
  Symbol lookup(Position pos, String name) {
    var symbol = find(name);
    if (symbol == null) {
      err.printf("ResolveSymbolError%s[Could not find %s.]%n", pos, name);
      encounteredError = true;
      return new Symbol(name, "ResolveSymbolError");
    } else {
      return symbol;
    }
  }

  /**
   * Try to find a symbol in the table starting form the most recent scope.
   */
  private Symbol find(String name) {
    for (int i = 0; i < len; i++) {
      Map<String, Symbol> m = symbolScopes.get(i);
      if (m.containsKey(name)) {
        return m.get(name);
      }
    }
    return null;
  }
}
