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
public class FileDataStream extends DataStream {

  private final String mFilePath;

  public FileDataStream(String filePath) {
    mFilePath = filePath;
  }

  @Override
  public String write(String content) {
    System.out.println("FileDataStream.write = " + content);
    return content;
  }

  @Override
  public String read(String content) {
    System.out.println("FileDataStream.read = " + content);
    return content;
  }
}
