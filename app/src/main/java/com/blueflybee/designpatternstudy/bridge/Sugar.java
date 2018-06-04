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
public class Sugar extends Additive {
  @Override
  public void add() {
    System.out.println("sugar coffee...");
  }
}
