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
public class TCPEstablished extends TCPState{
  private static TCPEstablished sTcpEstablished;

  private TCPEstablished() {
  }

  public static TCPState instance() {
    if (sTcpEstablished == null) {
      sTcpEstablished = new TCPEstablished();
    }
    return sTcpEstablished;
  }

  @Override
  public void close(TCPConnection connection) {
    super.close(connection);
    //send SYN, receive SYN, ACK, etc.
    changeState(connection, TCPListen.instance());
  }
}
