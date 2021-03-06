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
public class UpgradeMoonRoof extends MoonRoof {
  public UpgradeMoonRoof(String name) {
    super(name);
  }

  @Override
  public MoonRoof clone() {
    return new UpgradeMoonRoof(mName);
  }
}
