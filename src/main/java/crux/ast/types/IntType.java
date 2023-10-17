package crux.ast.types;

/**
 * Types for Integers values. This should implement the equivalent methods along with add, sub, mul,
 * div, and compare. The method equivalent will check if the param is an instance of IntType.
 */
public final class IntType extends Type implements java.io.Serializable {
  static final long serialVersionUID = 12022L;

  @Override
  public String toString() {
    return "int";
  }

  public boolean equivalent(Type that) {
    if (that.getClass() == this.getClass()) return true;
    return false;
  }

  public Type compare(Type that) {
    if (!equivalent(that))
      return super.compare(that);
    return new BoolType();
  }

  public Type add(Type that) {
    if (!equivalent(that))
      return super.compare(that);
    return new IntType();
  }

  public Type sub(Type that) {
    if (!equivalent(that))
      return super.compare(that);
    return new IntType();
  }

  public Type div(Type that) {
    if (!equivalent(that))
      return super.compare(that);
    return new IntType();
  }

  public Type mul(Type that) {
    if (!equivalent(that))
      return super.compare(that);
    return new IntType();
  }

  public Type assign(Type that) {
    if (!equivalent(that))
      return super.compare(that);
    return new IntType();
  }
}
