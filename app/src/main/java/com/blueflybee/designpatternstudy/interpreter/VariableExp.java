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
public class VariableExp implements BooleanExp {
  private final String mName;
  private ConstantExp mConstantExp;

  public VariableExp(String name) {
    mName = name;
  }

  @Override
  public BooleanExp copy() {
    return new VariableExp(mName);
  }

  @Override
  public BooleanExp evaluate(BooleanContext context) {

    return context.lookup(mName);
  }

  public void setValue(ConstantExp constantExp) {
    mConstantExp = constantExp;
  }

  public String getName() {
    return mName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    VariableExp that = (VariableExp) o;

    return mName.equals(that.mName);
  }

  @Override
  public int hashCode() {
    return mName.hashCode();
  }

  @Override
  public String toString() {
    return "VariableExp{" +
        "mName='" + mName + '\'' +
        '}';
  }
}
