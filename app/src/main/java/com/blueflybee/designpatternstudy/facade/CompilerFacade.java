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
public class CompilerFacade {
  //facade compile interface for common users use easily.
  public void compile() {
    Scanner scanner = new Scanner();
    Parser parser = new Parser();
    parser.setScanner(scanner);
    NodeBuilder builder = new NodeBuilder();
    parser.parse(builder);
  }
}
