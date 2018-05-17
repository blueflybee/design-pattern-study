package com.blueflybee.designpatternstudy.interpreter;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ConstantExp implements BooleanExp {
  private final boolean mConstant;

  public ConstantExp(boolean constant) {
    mConstant = constant;
  }

  @Override
  public BooleanExp copy() {
    return new ConstantExp(mConstant);
  }

  @Override
  public boolean evaluate(BooleanContext context) {
    return mConstant;
  }

  public boolean value() {
    return mConstant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ConstantExp that = (ConstantExp) o;

    return mConstant == that.mConstant;
  }

  @Override
  public int hashCode() {
    return (mConstant ? 1 : 0);
  }

  @Override
  public String toString() {
    return Boolean.toString(mConstant);
  }
}
