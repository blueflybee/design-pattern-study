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
public class DeluxeHood extends Hood {
  public DeluxeHood(String name) {
    super(name);
  }

  @Override
  public Hood clone() {
    return new Hood(mName);
  }
}
