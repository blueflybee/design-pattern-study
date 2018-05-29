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
public abstract class Display {

  public void display() {
    setFocus();
    onPrepare();
    onDisplay();
    resetFocus();
  }

  private void setFocus() {
    System.out.println("Display.setFocus");
  }

  protected void onPrepare() {
    System.out.println("Display.onPrepare");
  }

  protected abstract void onDisplay();

  private void resetFocus() {
    System.out.println("Display.resetFocus");
  }


}
