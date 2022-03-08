package com.hrexample;

import java.util.Objects;

/**
 * Abstract base class for domain entity classes used in the application that
 * provides a surrogate identity to such entity instances. The surrogate identity is
 * an integer value which not based on a natural or business key such as name or 
 * SSN, and is unique among instances of an specific domain entity.
 *
 * @since 1.0
 */
public abstract class SurrogateIdentity {
  /** 
   * The surrogate (non-business) identity of this object instance. The ID should
   * be unique among instances of an specific domain entity.
   */
  private int id;
 
  /**
   * Constructor that initializes the surrogate key.
   * 
   * @param anID 
   *   the ID of the instance, should be unique among instances of 
   *   a specific domain entity.
   */
  protected SurrogateIdentity(final int anID) {
    this.id = anID;
  }

  /**
   * Get the surrogate (non-business) identity of this object instance.
   *
   * @return the ID
   */
  public int getId() {
    return this.id;
  }

  /** @see java.lang.Object#equals(java.lang.Object) */
  @Override public boolean equals(final Object anObject) {
    boolean isEqual = false;
    if (anObject != null && anObject.getClass() == getClass()) {
      SurrogateIdentity otherObj = (SurrogateIdentity) anObject;
      isEqual = this.id == otherObj.id;
    }
    return isEqual;
  }

  /** @see java.lang.Object#hashCode() */
  @Override public int hashCode() {
    return Objects.hashCode(this.id);
  }
}
