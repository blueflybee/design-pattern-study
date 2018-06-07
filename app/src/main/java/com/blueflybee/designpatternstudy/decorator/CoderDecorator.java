package com.blueflybee.designpatternstudy.decorator;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CoderDecorator extends DataStream {
  protected final DataStream mDataStream;

  public CoderDecorator(DataStream dataStream) {
    mDataStream = dataStream;
  }

  @Override
  public String write(String content) {
    return mDataStream.write(content);
  }
}
