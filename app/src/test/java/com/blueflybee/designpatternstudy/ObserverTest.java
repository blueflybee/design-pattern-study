package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.memento.blackboxmemento.Caretaker;
import com.blueflybee.designpatternstudy.memento.blackboxmemento.IMemento;
import com.blueflybee.designpatternstudy.memento.blackboxmemento.Originator;
import com.blueflybee.designpatternstudy.observer.ClockTimer;
import com.blueflybee.designpatternstudy.observer.DigitalClock;
import com.blueflybee.designpatternstudy.observer.Observer;
import com.blueflybee.designpatternstudy.observer.Subject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   : Test command design pattern
 *     version: 1.0
 * </pre>
 */
public class ObserverTest {

  public static final String STATE_1 = "state_1";
  public static final String STATE_2 = "state_2";

  @Test
  public void subject_attach() throws Exception {
    Subject timer = spy(new ClockTimer());
    Observer clock = spy(new DigitalClock(timer));

    verify(timer).attach(any(DigitalClock.class));
  }


  @Test
  public void subject_detach() throws Exception {
    Subject timer = spy(new ClockTimer());
    Observer clock = spy(new DigitalClock(timer));
    timer.detach(clock);

    verify(timer).detach(any(DigitalClock.class));
  }

  @Test
  public void subject_attach_notify() throws Exception {
    Subject subject = spy(Subject.class);
    Observer observer = spy(Observer.class);
    subject.attach(observer);
    subject.notifyChanged();

    verify(subject).notifyChanged();
    verify(observer).update(subject);
  }

  @Test
  public void subject_detach_notify() throws Exception {
    Subject subject = spy(Subject.class);
    Observer observer = spy(Observer.class);
    subject.attach(observer);

    subject.detach(observer);
    subject.notifyChanged();
    verifyZeroInteractions(observer);
  }

//  @Test
//  public void timer_tick() throws Exception {
//    ClockTimer timer = spy(new ClockTimer());
//    Observer observer = spy(Observer.class);
//    timer.attach(observer);
//    timer.tick();
//    verify(timer).tick();
//    verify(timer).notifyChanged();
//    verify(observer).update(timer);
//
//  }


}
