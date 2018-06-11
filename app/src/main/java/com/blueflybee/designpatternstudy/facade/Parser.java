package com.blueflybee.designpatternstudy.facade;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Parser {
  private Scanner mScanner;

  public void setScanner(Scanner scanner) {

    mScanner = scanner;
  }

  public void parse(NodeBuilder builder) {
    builder.build();
    mScanner.scan();
  }
}
