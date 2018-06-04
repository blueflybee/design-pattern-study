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
public class SmallCoffee extends Coffee {

  public SmallCoffee(Additive additive) {
    super(additive);
  }

  @Override
  public void makeCoffee() {
    System.out.print("make small cup ");
    mAdditive.add();
  }


}
