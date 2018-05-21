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
public class ListTraver<E> implements Traversable<E> {

  @Override
  public Iterator<E> getIterator(AbstractList<E> list) {
    return new ListIterator<>(list);
  }
}
