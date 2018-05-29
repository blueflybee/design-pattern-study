package com.blueflybee.designpatternstudy.templatemethod;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/29
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TvDisplay extends Display {
  @Override
  protected void onDisplay() {
    System.out.println("TvDisplay.onDisplay");
  }

  @Override
  protected void onPrepare() {
    super.onPrepare();
    System.out.println("TvDisplay.onPrepare");
  }
}
