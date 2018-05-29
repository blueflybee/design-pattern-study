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
public class TCPConnection {
  private TCPState mTCPState;
  public TCPConnection() {
    mTCPState = TCPClosed.instance();
  }

  public void activeOpen() {
    mTCPState.activeOpen(this);
  }

  public void passiveOpen() {
    mTCPState.passiveOpen(this);
  }

  public void close() {
    mTCPState.close(this);
  }

  public void send() {
    mTCPState.send(this);
  }

  public void transmit() {
    mTCPState.transmit(this);
  }

  public void setState(TCPState state) {
    mTCPState = state;
  }

  public TCPState getState() {
    return mTCPState;
  }

  void changeState(TCPState state) {
    mTCPState = state;
  }
}
