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
public class SimpleCommand implements Command {

  private final Receiver mReceiver;

  public SimpleCommand(Receiver receiver) {
    mReceiver = receiver;
  }

  @Override
  public void execute() {
    if (mReceiver != null) {
      mReceiver.action();
    }
  }
}
