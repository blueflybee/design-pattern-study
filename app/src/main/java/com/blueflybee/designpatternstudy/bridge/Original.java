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
public class Original extends Additive {
  @Override
  public void add() {
    System.out.println("original coffee...");
  }
}
