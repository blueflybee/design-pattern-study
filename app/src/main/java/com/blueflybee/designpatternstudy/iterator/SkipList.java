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
public class SkipList<E> extends AbstractList<E> implements Traversable<E>{

  private Object[] items = new Object[100];
  private int count = 0;

  @Override
  public int count() {
    return count;
  }

  @Override
  public void add(E e) {
    items[count++] = e;
  }

  @Override
  public E remove(int index) {
    return null;
  }

  @Override
  public Iterator<E> iterator() {
    return new SkipListIterator<>(this);
  }

  @Override
  public E get(int index) {
    return (E) items[index];
  }

  @Override
  public Iterator<E> getIterator(AbstractList<E> list) {
    return super.getIterator(list);
  }
}
