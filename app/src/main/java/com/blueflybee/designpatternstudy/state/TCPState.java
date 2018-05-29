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
public class TCPState {
  public void activeOpen(TCPConnection connection) {

  }

  public void passiveOpen(TCPConnection connection) {

  }

  public void close(TCPConnection connection) {

  }

  public void send(TCPConnection connection) {

  }

  public void transmit(TCPConnection connection) {

  }


  protected void changeState(TCPConnection connection, TCPState state) {
    connection.changeState(state);

  }

}
