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
public class UpgradeHood extends Hood {
  public UpgradeHood(String name) {
    super(name);
  }

  @Override
  public Hood clone() {
    return new Hood(mName);
  }
}
