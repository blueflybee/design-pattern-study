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
public class PrintNEmpIterator<E> extends InnerIterator<E> {

  private final int mCount;
  private int mIndex;

  public PrintNEmpIterator(AbstractList<E> list, int count) {
    super(list);
    mCount = count;
  }

  @Override
  protected boolean processElement(E e) {
    System.out.println("e = " + e);
    mIndex ++;
    return mIndex < mCount;
  }
}
