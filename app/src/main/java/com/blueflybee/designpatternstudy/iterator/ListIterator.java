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
public class ListIterator<E> extends Iterator<E> {


  private final int mCount;
  private List<E> mList;
  private int mIndex = 0;

  public ListIterator(List<E> list) {
    mList = list;
    mCount = list.count();
  }

  @Override
  public void first() {
    mIndex = 0;
  }

  @Override
  public int index() {
    return mIndex;
  }

  @Override
  public void next() {
    mIndex++;
  }

  @Override
  public boolean hasNext() {
    return mIndex < mList.count();
  }

  @Override
  public E currentItem() {
    return mList.get(mIndex);
  }
}
