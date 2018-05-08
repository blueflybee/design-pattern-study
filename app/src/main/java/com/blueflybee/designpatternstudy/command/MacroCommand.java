package com.blueflybee.designpatternstudy.command;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MacroCommand implements Command {

  private List<Command> mCommands = new ArrayList<>();

  @Override
  public void execute() {
    for (Command command : mCommands) {
      command.execute();
    }

  }

  public int size() {
    return mCommands.size();
  }

  public void add(Command c) {
    mCommands.add(c);
  }

  public void remove(Command c) {
    mCommands.remove(c);
  }
}
