package com.blueflybee.designpatternstudy.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Subject {
  private List<Observer> mObservers = new ArrayList<>();

  public void attach(Observer o) {
    mObservers.add(o);
  }

  public void detach(Observer o) {
    mObservers.remove(o);
  }

  public void notifyChanged() {
    for (Observer o : mObservers) {
      o.update(this);
    }
  }

}
