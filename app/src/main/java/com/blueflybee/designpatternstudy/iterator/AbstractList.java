package com.blueflybee.designpatternstudy.iterator;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class AbstractList<E> {
  protected Traversable<E> mTraver;

  public abstract int count();

  public abstract void add(E e);

  public abstract E remove(int index);

  public abstract Iterator<E> iterator();

  public abstract E get(int index);

  public void setTraver(Traversable traver) {
    mTraver = traver;
  }

  public Iterator<E> getIterator(AbstractList<E> list) {
    if (mTraver != null) {
      return mTraver.getIterator(list);
    }
    return null;
  }

}
