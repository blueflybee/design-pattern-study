package com.blueflybee.designpatternstudy.composite;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class DeluxeTire extends Tire {
  public DeluxeTire(String name) {
    super(name);
  }

  @Override
  public Tire clone() {
    return new DeluxeTire(mName);
  }
}
