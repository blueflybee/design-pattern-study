package com.blueflybee.designpatternstudy.flyweight;


import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Glyph {
  protected final String mName;

  public Glyph(String name) {
    mName = name;
  }

  public void add(Glyph g) {
  }

  public int rowSize() {
    return 0;
  }

  public int characterSize() {
    return 0;
  }

  @Override
  public String toString() {
    return mName;
  }

  public String print() {
    return null;
  }
}
