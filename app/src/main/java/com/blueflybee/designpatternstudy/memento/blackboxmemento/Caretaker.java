package com.blueflybee.designpatternstudy.memento.blackboxmemento;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/24
 *     desc   : 备忘录外部存储处，在某个时间点从这里恢复存储的状态，拥有对Memento的窄接口
 *     version: 1.0
 * </pre>
 */
public class Caretaker {
  private IMemento mMemento;

  public void setMemento(IMemento memento) {
    mMemento = memento;
  }

  public IMemento getMemento() {
    return mMemento;
  }
}
