package crux.ast.types;

/**
 * Types for Booleans values This should implement the equivalent methods along with and,or, and not
 * equivalent will check if the param is instance of BoolType
 */
public final class BoolType extends Type implements java.io.Serializable {
  static final long serialVersionUID = 12022L;

  @Override
  public String toString() {
    return "bool";
  }

  public boolean equivalent(Type that) {
    if (that.getClass() == this.getClass()) return true;
    return false;
  }

  public Type and(Type that) {
    if (!equivalent(that))
      return super.compare(that);
    return new BoolType();
  }

  public Type or(Type that) {
    if (!equivalent(that))
      return super.compare(that);
    return new BoolType();
  }

  public Type not() {
    if (!equivalent(this))
      return super.compare(this);
    return new BoolType();
  }
  public Type assign(Type that) {
    if (!equivalent(that))
      return super.compare(that);
    return new BoolType();
  }
}
