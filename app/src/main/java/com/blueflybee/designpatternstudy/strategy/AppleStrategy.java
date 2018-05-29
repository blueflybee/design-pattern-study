package com.blueflybee.designpatternstudy.strategy;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/29
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class AppleStrategy extends Strategy {

  private static AppleStrategy sStrategy;

  public static Strategy instance() {
    if (sStrategy == null) {
      sStrategy = new AppleStrategy();
    }
    return sStrategy;
  }

  @Override
  public void evaluate(StrategyContext context) {
    System.out.println("apple strategy");
  }
}
