package com.blueflybee.designpatternstudy.observer;

import com.blueflybee.designpatternstudy.memento.blackboxmemento.Caretaker;
import com.blueflybee.designpatternstudy.memento.blackboxmemento.IMemento;
import com.blueflybee.designpatternstudy.memento.blackboxmemento.Originator;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ObserverDemo {


  public static void main(String[] args) {
    ClockTimer timer = new ClockTimer();
    DigitalClock digitalClock = new DigitalClock(timer);
    timer.tick();

  }
}
