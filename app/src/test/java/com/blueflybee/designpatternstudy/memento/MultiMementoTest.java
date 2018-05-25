package com.blueflybee.designpatternstudy.memento;


import com.blueflybee.designpatternstudy.memento.blackboxmemento.IMemento;
import com.blueflybee.designpatternstudy.memento.multimemento.Caretaker;
import com.blueflybee.designpatternstudy.memento.multimemento.Originator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   : Test command design pattern
 *     version: 1.0
 * </pre>
 */
public class MultiMementoTest {

  public static final String STATE_1 = "state_1";
  public static final String STATE_2 = "state_2";
  public static final String STATE_3 = "state_3";
  public static final String STATE_4 = "state_4";
  public static final String STATE_5 = "state_5";
  public static final String STATE_6 = "state_6";

  @Test
  public void originator_singleton() throws Exception {
    Originator solver1 = Originator.instance();
    Originator solver2 = Originator.instance();
    assertNotNull(solver1);
    assertNotNull(solver2);
    assertSame(solver1, solver2);
  }


  @Test
  public void multi_save_and_restore() throws Exception {
    //create and save memento
    Originator originator = spy(Originator.instance());

    Caretaker caretaker = spy(new Caretaker(originator));
    originator.setState(STATE_1);
    caretaker.createMemento();
    verify(caretaker).createMemento();
    verify(originator).createMemento();

    originator.setState(STATE_2);
    caretaker.createMemento();

    originator.setState(STATE_3);
    caretaker.createMemento();

    originator.setState(STATE_4);
    caretaker.createMemento();

    originator.setState(STATE_5);
    caretaker.createMemento();

    originator.setState(STATE_6);
    caretaker.createMemento();

    System.out.println("caretaker = " + caretaker);

    caretaker.setMemento(0);
    assertEquals(STATE_1, originator.getState());

    caretaker.setMemento(1);
    assertEquals(STATE_2, originator.getState());

    caretaker.setMemento(2);
    assertEquals(STATE_3, originator.getState());

    caretaker.setMemento(3);
    assertEquals(STATE_4, originator.getState());

    caretaker.setMemento(4);
    assertEquals(STATE_5, originator.getState());

    caretaker.setMemento(5);
    assertEquals(STATE_6, originator.getState());


  }


}
