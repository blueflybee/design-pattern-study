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
public class NotExp implements BooleanExp {
  private final BooleanExp mExp;

  public NotExp(BooleanExp exp) {
    mExp = exp;
  }

  @Override
  public BooleanExp copy() {
    return new NotExp(mExp.copy());
  }

  @Override
  public boolean evaluate(BooleanContext context) {

    return !mExp.evaluate(context);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    NotExp notExp = (NotExp) o;

    return mExp.equals(notExp.mExp);
  }

  @Override
  public int hashCode() {
    return mExp.hashCode();
  }

  @Override
  public String toString() {
    return "NotExp{" +
        "mExp=" + mExp +
        '}';
  }
}
