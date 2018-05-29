package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.observer.ClockTimer;
import com.blueflybee.designpatternstudy.observer.DigitalClock;
import com.blueflybee.designpatternstudy.observer.Observer;
import com.blueflybee.designpatternstudy.observer.Subject;
import com.blueflybee.designpatternstudy.state.TCPClosed;
import com.blueflybee.designpatternstudy.state.TCPConnection;
import com.blueflybee.designpatternstudy.state.TCPEstablished;
import com.blueflybee.designpatternstudy.state.TCPListen;
import com.blueflybee.designpatternstudy.state.TCPState;

import org.junit.Test;
import org.mockito.Matchers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   : Test command design pattern
 *     version: 1.0
 * </pre>
 */
public class StateTest {

  @Test
  public void tcpState_default_methods() {
    TCPState state = spy(TCPState.class);
    TCPConnection connection = mock(TCPConnection.class);
    state.activeOpen(connection);
    verify(state).activeOpen(connection);

    state.passiveOpen(connection);
    verify(state).passiveOpen(connection);

    state.close(connection);
    verify(state).close(connection);

    state.send(connection);
    verify(state).send(connection);

    state.transmit(connection);
    verify(state).transmit(connection);

  }

  @Test
  public void tcpConnection_methods() {
    TCPState state = spy(TCPState.class);
    TCPConnection connection = spy(new TCPConnection());
    connection.setState(state);

    connection.activeOpen();
    verify(state).activeOpen(connection);

    connection.passiveOpen();
    verify(state).passiveOpen(connection);

    connection.close();
    verify(state).close(connection);

    connection.send();
    verify(state).send(connection);

    connection.transmit();
    verify(state).transmit(connection);

  }

  @Test
  public void tcpState_closed_established() {
    TCPConnection connection = spy(new TCPConnection());
    connection.activeOpen();
    TCPState state = connection.getState();
    assertTrue(state instanceof TCPEstablished);
  }

  @Test
  public void tcpState_closed_listen() {
    TCPConnection connection = spy(new TCPConnection());
    connection.passiveOpen();
    TCPState state = connection.getState();
    assertTrue(state instanceof TCPListen);
  }

  @Test
  public void tcpState_established_listen() {
    TCPConnection connection = spy(new TCPConnection());
    connection.activeOpen();
    TCPState state = connection.getState();
    assertTrue(state instanceof TCPEstablished);

    connection.close();
    state = connection.getState();
    assertTrue(state instanceof TCPListen);
  }

  @Test
  public void tcpState_listen_established() {
    TCPConnection connection = spy(new TCPConnection());
    connection.passiveOpen();
    TCPState state = connection.getState();
    assertTrue(state instanceof TCPListen);

    connection.send();
    state = connection.getState();
    assertTrue(state instanceof TCPEstablished);
  }


}
