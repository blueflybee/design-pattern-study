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
public class PasteCommand implements Command {
  private final Document mDocument;

  public PasteCommand(Document document) {
    mDocument = document;
  }

  @Override
  public void execute() {
    mDocument.paste();
  }
}
