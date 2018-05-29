package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.state.TCPConnection;
import com.blueflybee.designpatternstudy.state.TCPEstablished;
import com.blueflybee.designpatternstudy.state.TCPListen;
import com.blueflybee.designpatternstudy.state.TCPState;
import com.blueflybee.designpatternstudy.strategy.AppleStrategy;
import com.blueflybee.designpatternstudy.strategy.LitchiStrategy;
import com.blueflybee.designpatternstudy.strategy.Strategy;
import com.blueflybee.designpatternstudy.strategy.StrategyContext;
import com.blueflybee.designpatternstudy.strategy.WatermelonStrategy;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
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
public class StrategyTest {

  @Test
  public void applyAppleStrategy() {
    StrategyContext context = mock(StrategyContext.class);
    Strategy strategy = spy(AppleStrategy.instance());
    assertTrue(strategy instanceof AppleStrategy);
    strategy.evaluate(context);
    verify(strategy).evaluate(context);
  }

  @Test
  public void applyWatermelonStrategy() {
    StrategyContext context = mock(StrategyContext.class);
    Strategy strategy = spy(WatermelonStrategy.instance());
    assertTrue(strategy instanceof WatermelonStrategy);
    strategy.evaluate(context);
    verify(strategy).evaluate(context);
  }

  @Test
  public void applyLitchiStrategy() {
    StrategyContext context = mock(StrategyContext.class);
    Strategy strategy = spy(LitchiStrategy.instance());
    assertTrue(strategy instanceof LitchiStrategy);
    strategy.evaluate(context);
    verify(strategy).evaluate(context);
  }


}
