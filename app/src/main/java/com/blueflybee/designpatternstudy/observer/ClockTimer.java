package com.blueflybee.designpatternstudy.observer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ClockTimer extends Subject {

  private Timer mTimer;
  private TimerTask mTask;

  public ClockTimer() {
  }

  public void tick() {
    mTimer = new Timer();
    mTask = new TimerTask() {
      @Override
      public void run() {
        notifyChanged();
      }
    };
    mTimer.schedule(mTask, 0, 1000);
  }

  public String getTime() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    return format.format(new Date());
  }

  public void stop() {
    mTimer.cancel();
    mTask.cancel();
    mTimer = null;
    mTask = null;
  }
}
