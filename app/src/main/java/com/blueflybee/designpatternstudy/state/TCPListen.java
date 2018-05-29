package com.blueflybee.designpatternstudy.state;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/29
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TCPListen extends TCPState{
  private static TCPListen sTCPListen;

  private TCPListen() {
  }

  public static TCPState instance() {
    if (sTCPListen == null) {
      sTCPListen = new TCPListen();
    }
    return sTCPListen;
  }

  @Override
  public void send(TCPConnection connection) {
    super.send(connection);
    //send SYN, receive SYN, ACK, etc.
    changeState(connection, TCPEstablished.instance());
  }
}
