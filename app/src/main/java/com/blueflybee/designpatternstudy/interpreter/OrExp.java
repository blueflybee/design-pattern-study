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
public class OrExp implements BooleanExp {
  private final BooleanExp mExp1;
  private final BooleanExp mExp2;

  public OrExp(BooleanExp exp1, BooleanExp exp2) {
    mExp1 = exp1;
    mExp2 = exp2;
  }

  @Override
  public BooleanExp copy() {
    return new OrExp(mExp1.copy(), mExp2.copy());
  }

  @Override
  public boolean evaluate(BooleanContext context) {

    return mExp1.evaluate(context) || mExp2.evaluate(context);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    OrExp orExp = (OrExp) o;

    if (!mExp1.equals(orExp.mExp1)) return false;
    return mExp2.equals(orExp.mExp2);
  }

  @Override
  public int hashCode() {
    int result = mExp1.hashCode();
    result = 31 * result + mExp2.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "(" + mExp1 + " || " + mExp2 + ")";
  }
}
