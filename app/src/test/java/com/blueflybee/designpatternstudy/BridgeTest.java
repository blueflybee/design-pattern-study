package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.bridge.Additive;
import com.blueflybee.designpatternstudy.bridge.BigCoffee;
import com.blueflybee.designpatternstudy.bridge.Coffee;
import com.blueflybee.designpatternstudy.bridge.Original;
import com.blueflybee.designpatternstudy.bridge.SmallCoffee;
import com.blueflybee.designpatternstudy.bridge.Sugar;
import com.blueflybee.designpatternstudy.visitor.Bus;
import com.blueflybee.designpatternstudy.visitor.Card;
import com.blueflybee.designpatternstudy.visitor.Equipment;
import com.blueflybee.designpatternstudy.visitor.EquipmentComposite;
import com.blueflybee.designpatternstudy.visitor.FloppyDisk;
import com.blueflybee.designpatternstudy.visitor.MainBoard;
import com.blueflybee.designpatternstudy.visitor.Power;
import com.blueflybee.designpatternstudy.visitor.PriceVisitor;
import com.blueflybee.designpatternstudy.visitor.PrintVisitor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   : Test command design pattern
 *     version: 1.0
 * </pre>
 */
public class BridgeTest {

  @Test
  public void smallCupCoffee_originalTaste() {
    Additive additive = spy(new Original());
    Coffee smallCoffee = spy(new SmallCoffee(additive));
    smallCoffee.makeCoffee();
    verify(smallCoffee).makeCoffee();
    verify(additive).add();
  }

  @Test
  public void smallCupCoffee_sugarTaste() {
    Additive additive = spy(new Sugar());
    Coffee smallCoffee = spy(new SmallCoffee(additive));
    smallCoffee.makeCoffee();
    verify(smallCoffee).makeCoffee();
    verify(additive).add();
  }

  @Test
  public void bigCupCoffee_originalTaste() {
    Additive additive = spy(new Original());
    Coffee coffee = spy(new BigCoffee(additive));
    coffee.makeCoffee();
    verify(coffee).makeCoffee();
    verify(additive).add();
  }

  @Test
  public void bigCupCoffee_sugarTaste() {
    Additive additive = spy(new Sugar());
    Coffee coffee = spy(new BigCoffee(additive));
    coffee.makeCoffee();
    verify(coffee).makeCoffee();
    verify(additive).add();
  }

}
