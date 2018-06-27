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
public class UpgradeTire extends Tire {
  public UpgradeTire(String name) {
    super(name);
  }

  @Override
  public Tire clone() {
    return new UpgradeTire(mName);
  }
}
