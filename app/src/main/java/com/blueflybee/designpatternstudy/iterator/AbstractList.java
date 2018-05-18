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
  public abstract int count();

  public abstract void add(E e);

  public abstract E remove(int index);

  public abstract Iterator<E> iterator();

  public abstract E get(int index);
}
