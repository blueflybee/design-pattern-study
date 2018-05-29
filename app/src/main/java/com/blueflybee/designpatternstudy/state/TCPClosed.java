package com.blueflybee.designpatternstudy.state;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TCPClosed extends TCPState {

  private static TCPState sTCPClosed;

  private TCPClosed() {
  }

  public static TCPState instance() {
    if (sTCPClosed == null) {
      sTCPClosed = new TCPClosed();
    }
    return sTCPClosed;
  }

  @Override
  public void activeOpen(TCPConnection connection) {
    super.activeOpen(connection);
    //send SYN, receive SYN, ACK, etc.
    changeState(connection, TCPEstablished.instance());
  }

  @Override
  public void passiveOpen(TCPConnection connection) {
    super.passiveOpen(connection);
    //send SYN, receive SYN, ACK, etc.
    changeState(connection, TCPListen.instance());
  }
}
