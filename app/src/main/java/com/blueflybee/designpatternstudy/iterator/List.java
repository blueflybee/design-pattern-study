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
public class List<E> extends AbstractList<E> {

  private Object[] items = new Object[100];
  private int count = 0;

  public List() {
  }

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
    if (index >= count)
      throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

    E oldValue = (E) items[index];

    int numMoved = count - index - 1;
    if (numMoved > 0)
      System.arraycopy(items, index + 1, items, index,
          numMoved);
    items[--count] = null; // clear to let GC do its work

    return oldValue;
  }

  @Override
  public Iterator<E> iterator() {
    return new ListIterator<>(this);
  }

  @Override
  public E get(int index) {
    return (E) items[index];
  }

  private String outOfBoundsMsg(int index) {
    return "Index: " + index + ", Size: " + count;
  }

}
