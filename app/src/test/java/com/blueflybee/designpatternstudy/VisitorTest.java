package com.blueflybee.designpatternstudy;

import android.support.annotation.NonNull;

import com.blueflybee.designpatternstudy.strategy.AppleStrategy;
import com.blueflybee.designpatternstudy.strategy.LitchiStrategy;
import com.blueflybee.designpatternstudy.strategy.Strategy;
import com.blueflybee.designpatternstudy.strategy.StrategyContext;
import com.blueflybee.designpatternstudy.strategy.WatermelonStrategy;
import com.blueflybee.designpatternstudy.visitor.Bus;
import com.blueflybee.designpatternstudy.visitor.Card;
import com.blueflybee.designpatternstudy.visitor.Equipment;
import com.blueflybee.designpatternstudy.visitor.EquipmentComposite;
import com.blueflybee.designpatternstudy.visitor.EquipmentVisitor;
import com.blueflybee.designpatternstudy.visitor.FloppyDisk;
import com.blueflybee.designpatternstudy.visitor.MainBoard;
import com.blueflybee.designpatternstudy.visitor.Power;
import com.blueflybee.designpatternstudy.visitor.PriceVisitor;
import com.blueflybee.designpatternstudy.visitor.PrintVisitor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
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
public class VisitorTest {

  @Test
  public void createCompositeEquipmentStruct() {
    Equipment pc = createPC();
    verify(pc, times(4)).add(any(Equipment.class));
    assertEquals(5, pc.size());
  }

  @Test
  public void createPriceVisitor_calculatePrice() {
    Equipment pc = createPC();
    PriceVisitor priceVisitor = spy(new PriceVisitor());
    pc.accept(priceVisitor);
    assertEquals(2700, priceVisitor.getTotalPrice());
  }

  @Test
  public void createPrintVisitor_printPrice() {
    Equipment pc = createPC();
    PrintVisitor printVisitor = spy(new PrintVisitor());
    pc.accept(printVisitor);
    printVisitor.print();
  }

  private Equipment createPC() {
    Equipment chassis = spy(new EquipmentComposite());
    chassis.setName("机箱");
    Equipment mainBoard = spy(new MainBoard());
    mainBoard.setName("主板");
    mainBoard.setPrice(1000);
    Equipment power = spy(new Power());
    power.setName("电源");
    power.setPrice(500);
    chassis.add(mainBoard);
    chassis.add(power);
    verify(chassis, times(2)).add(any(Equipment.class));
    assertEquals(2, chassis.size());

    Equipment floppyDisk = spy(new FloppyDisk());
    floppyDisk.setName("软盘");
    floppyDisk.setPrice(200);
    Equipment card = spy(new Card());
    card.setName("显卡");
    card.setPrice(200);
    Equipment bus = spy(new Bus());
    bus.setName("总线");
    bus.setPrice(800);

    Equipment pc = spy(new EquipmentComposite());
    pc.setName("总计");
    pc.add(chassis);
    pc.add(floppyDisk);
    pc.add(card);
    pc.add(bus);
    return pc;
  }


}
