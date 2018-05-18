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
public abstract class Iterator<E> {
  public abstract void first();

  public abstract int index();

  public abstract void next();

  public abstract boolean hasNext();

  public abstract E currentItem();
}
