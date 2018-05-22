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

  private final DialogDirector mDialogDirector;

  public Widget(DialogDirector dialogDirector) {
    mDialogDirector = dialogDirector;
  }

  public void changed() {
    mDialogDirector.onWidgetChanged(this);
  }
}
