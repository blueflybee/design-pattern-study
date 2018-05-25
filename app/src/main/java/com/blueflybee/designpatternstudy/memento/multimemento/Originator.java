package com.blueflybee.designpatternstudy.memento.multimemento;

import com.blueflybee.designpatternstudy.memento.blackboxmemento.IMemento;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/24
 *     desc   : 需要存储备忘状态的对象，负责创建Memento对象和从Memento对象恢复状态。拥有对Memento类的宽接口
 *     version: 1.0
 * </pre>
 */
public class Originator {
  private static Originator sSolver;
  private String mState;

  private Originator() {
  }

  public static Originator instance() {
    if (sSolver == null) {
      sSolver = new Originator();
    }
    return sSolver;
  }

  public IMemento createMemento() {
    Memento memento = new Memento();
    memento.state = mState;
    return memento;
  }

  public void setState(String state) {
    mState = state;
  }

  public void setMemento(IMemento memento) {
    setState(((Memento) memento).state);
  }

  public String getState() {
    return mState;
  }


  private final class Memento implements IMemento {
    private String state;
    private Memento() {}

    @Override
    public String toString() {
      return "Memento{" +
          "state='" + state + '\'' +
          '}';
    }
  }

  @Override
  public String toString() {
    return "Originator{" +
        "mState='" + mState + '\'' +
        '}';
  }
}
