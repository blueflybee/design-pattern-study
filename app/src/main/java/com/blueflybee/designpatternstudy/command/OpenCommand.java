package com.blueflybee.designpatternstudy.command;

import android.text.TextUtils;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class OpenCommand implements Command {
  private final CommandApplication mApplication;

  public OpenCommand(CommandApplication application) {
    mApplication = application;
  }

  @Override
  public void execute() {
    String name = askUser();
    if (!name.isEmpty()) {
      Document document = new Document(name);
      mApplication.add(document);
      document.open();
    }

  }

  private String askUser() {
    return "new doc";
  }
}
