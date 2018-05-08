package com.blueflybee.designpatternstudy.command;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Document {

  public Document() {
  }

  public Document(String name) {

  }

  public void open() {
    System.out.println("Document.open");

  }

  public void paste() {
    System.out.println("Document.paste");

  }
}
