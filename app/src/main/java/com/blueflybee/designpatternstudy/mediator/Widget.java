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
public abstract class Widget {

  private final ViewMediator mViewMediator;

  public Widget(ViewMediator viewMediator) {
    mViewMediator = viewMediator;
  }

  public void changed() {
    mViewMediator.onWidgetChanged(this);
  }
}
