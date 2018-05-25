package com.blueflybee.designpatternstudy.memento.multimemento;


/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MultiMementoDemo {
  public static final String STATE_1 = "state_1";
  public static final String STATE_2 = "state_2";
  public static final String STATE_3 = "state_3";
  public static final String STATE_4 = "state_4";
  public static final String STATE_5 = "state_5";
  public static final String STATE_6 = "state_6";


  public static void main(String[] args) {
    //Originator set state and create memento
    Originator originator = Originator.instance();

    Caretaker caretaker = new Caretaker(originator);
    originator.setState(STATE_1);
    caretaker.createMemento();

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
    System.out.println("restore to state 1");
    System.out.println("originator = " + originator);

    caretaker.setMemento(1);
    System.out.println("restore to state 2");
    System.out.println("originator = " + originator);

    caretaker.setMemento(2);
    System.out.println("restore to state 3");
    System.out.println("originator = " + originator);

    caretaker.setMemento(3);
    System.out.println("restore to state 4");
    System.out.println("originator = " + originator);

    caretaker.setMemento(4);
    System.out.println("restore to state 5");
    System.out.println("originator = " + originator);

    caretaker.setMemento(5);
    System.out.println("restore to state 6");
    System.out.println("originator = " + originator);
  }
}
