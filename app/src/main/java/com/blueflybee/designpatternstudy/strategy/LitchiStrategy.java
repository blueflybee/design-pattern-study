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
public class LitchiStrategy extends Strategy {
  public static Strategy instance() {
    return new LitchiStrategy();
  }

  @Override
  public void evaluate(StrategyContext context) {

  }
}
