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
public class WatermelonStrategy extends Strategy {
  public static Strategy instance() {
    return new WatermelonStrategy();
  }

  @Override
  public void evaluate(StrategyContext context) {

  }
}
