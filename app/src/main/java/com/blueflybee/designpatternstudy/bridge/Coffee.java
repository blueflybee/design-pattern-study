package com.blueflybee.designpatternstudy.bridge;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class Coffee {
  protected final Additive mAdditive;

  Coffee(Additive additive) {
    mAdditive = additive;
  }

  public abstract void makeCoffee();
}
