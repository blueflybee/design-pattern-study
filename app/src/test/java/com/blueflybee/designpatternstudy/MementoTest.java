package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.memento.Caretaker;
import com.blueflybee.designpatternstudy.memento.IMemento;
import com.blueflybee.designpatternstudy.memento.Originator;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   : Test command design pattern
 *     version: 1.0
 * </pre>
 */
public class MementoTest {

  public static final String STATE_1 = "state_1";
  public static final String STATE_2 = "state_2";

  @Test
  public void originator_singleton() throws Exception {
    Originator solver1 = Originator.instance();
    Originator solver2 = Originator.instance();
    assertNotNull(solver1);
    assertNotNull(solver2);
    assertSame(solver1, solver2);
  }


  @Test
  public void save_restore_state() throws Exception {
    //create and save memento
    Originator originator = spy(Originator.instance());
    originator.setState(STATE_1);
    IMemento savedMemento = originator.createMemento();
    verify(originator).createMemento();
    assertNotNull(savedMemento);

    Caretaker caretaker = spy(Caretaker.class);
    caretaker.setMemento(savedMemento);
    verify(caretaker).setMemento(savedMemento);

    assertEquals(STATE_1, originator.getState());

    //set next new state
    originator.setState(STATE_2);
    assertEquals(STATE_2, originator.getState());

    //restore memento from ex
    IMemento restoredMemento = caretaker.getMemento();

    originator.setMemento(restoredMemento);
    assertEquals(STATE_1, originator.getState());

  }



}
