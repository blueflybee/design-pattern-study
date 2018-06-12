package com.blueflybee.designpatternstudy.flyweight;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Character extends Glyph {
  public Character(String c) {
    super(c);
  }

  @Override
  public int characterSize() {
    return 1;
  }

  @Override
  public String print() {
    return mName;
  }
}
