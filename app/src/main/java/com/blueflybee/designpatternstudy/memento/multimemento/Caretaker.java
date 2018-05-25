package com.blueflybee.designpatternstudy.memento.multimemento;

import com.blueflybee.designpatternstudy.memento.blackboxmemento.IMemento;

import java.util.Vector;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/25
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Caretaker {
  private final Originator mOriginator;
  private final Vector<IMemento> mMementos = new Vector<>();

  public Caretaker(Originator originator) {

    mOriginator = originator;
  }

  public void createMemento() {
    mMementos.add(mOriginator.createMemento());
  }

  public void setMemento(int index) {
    IMemento iMemento = mMementos.elementAt(index);
    mOriginator.setMemento(iMemento);
  }

  @Override
  public String toString() {
    return "Caretaker{" +
        "mOriginator=" + mOriginator +
        ", mMementos=" + mMementos +
        '}';
  }
}
