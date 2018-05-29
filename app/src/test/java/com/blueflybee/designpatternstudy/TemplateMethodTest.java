package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.strategy.AppleStrategy;
import com.blueflybee.designpatternstudy.strategy.LitchiStrategy;
import com.blueflybee.designpatternstudy.strategy.Strategy;
import com.blueflybee.designpatternstudy.strategy.StrategyContext;
import com.blueflybee.designpatternstudy.strategy.WatermelonStrategy;
import com.blueflybee.designpatternstudy.templatemethod.Display;
import com.blueflybee.designpatternstudy.templatemethod.PhoneDisplay;
import com.blueflybee.designpatternstudy.templatemethod.TvDisplay;

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
public class TemplateMethodTest {

  @Test
  public void tvDisplay() {
    Display display = spy(new TvDisplay());
    display.display();

    verify(display).display();
  }

  @Test
  public void phoneDisplay() {
    Display display = spy(new PhoneDisplay());
    display.display();

    verify(display).display();
  }
}
