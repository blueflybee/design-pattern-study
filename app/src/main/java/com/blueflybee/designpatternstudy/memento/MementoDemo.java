package com.blueflybee.designpatternstudy.memento;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MementoDemo {
  public static final String STATE_1 = "state_1";
  public static final String STATE_2 = "state_2";


  public static void main(String[] args) {
    //Originator set state and create memento
    Originator originator = Originator.instance();
    originator.setState(STATE_1);
    System.out.println("saved state = " + originator.getState());
    IMemento savedMemento = originator.createMemento();

    //save memento external
    Caretaker caretaker = new Caretaker();
    caretaker.setMemento(savedMemento);

    //Originator state changed
    originator.setState(STATE_2);
    System.out.println("changed state = " + originator.getState());

    //restore memento sometimes
    IMemento restoredMemento = caretaker.getMemento();
    originator.setMemento(restoredMemento);
    System.out.println("restored state = " + originator.getState());

  }
}
