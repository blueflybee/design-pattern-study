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
public class BigCoffee extends Coffee {

  public BigCoffee(Additive additive) {
    super(additive);
  }

  @Override
  public void makeCoffee() {
    System.out.print("make big cup ");
    mAdditive.add();
  }
}
