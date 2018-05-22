package com.blueflybee.designpatternstudy.mediator;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class ViewMediator {

  public void showDialog() {
    createWidgets();
  }

  public abstract void createWidgets();

  public abstract void onWidgetChanged(Widget widget);
}
