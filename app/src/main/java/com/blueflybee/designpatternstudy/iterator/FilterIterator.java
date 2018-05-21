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
public class FilterIterator<E> extends InnerIterator<E> {
  private final IterFilter<E> mFilter;

  public FilterIterator(AbstractList<E> list, IterFilter<E> filter) {
    super(list);
    mFilter = filter;
  }

  @Override
  public boolean traverse() {
    return super.traverse();
  }

  @Override
  protected boolean processElement(E e) {
    if (mFilter.correct(e)) {
      System.out.println("e = " + e);
    }
    return true;
  }
}
