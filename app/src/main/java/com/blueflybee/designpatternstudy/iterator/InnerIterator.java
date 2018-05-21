package com.blueflybee.designpatternstudy.iterator;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class InnerIterator<E> {

  protected final AbstractList<E> mList;

  public InnerIterator(AbstractList<E> list) {

    mList = list;
  }

  public boolean traverse() {
    if (mList == null || mList.count() == 0) return false;
    boolean result = false;
    Iterator<E> iterator = mList.iterator();
    for (iterator.first(); iterator.hasNext(); iterator.next()){
      result = processElement(iterator.currentItem());
      if (!result) break;
    }
    return result;
  }

  protected abstract boolean processElement(E e);
}
