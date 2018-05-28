package com.blueflybee.designpatternstudy.observer;


/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class DigitalClock extends Observer {
  private final Subject mSubject;
  private OnUpdateListener mOnUpdateListener;

  public DigitalClock(Subject subject) {

    mSubject = subject;
    mSubject.attach(this);
  }

  @Override
  public void update(Subject subject) {
    super.update(subject);
    if (subject == mSubject) {
      String time = ((ClockTimer) subject).getTime();
      System.out.println("time = " + time);
      if (mOnUpdateListener != null) {
        mOnUpdateListener.onUpdate(time);
      }
    }
  }

  public void setOnUpdateListener(OnUpdateListener onUpdateListener) {
    mOnUpdateListener = onUpdateListener;
  }

  @Override
  public String toString() {
    return "DigitalClock{" +
        "mSubject=" + mSubject +
        '}';
  }

  interface OnUpdateListener{
    void onUpdate(String time);
  }

}
