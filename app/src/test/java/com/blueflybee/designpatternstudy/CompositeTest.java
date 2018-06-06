package com.blueflybee.designpatternstudy;

import android.support.annotation.NonNull;

import com.blueflybee.designpatternstudy.composite.CarEquipment;
import com.blueflybee.designpatternstudy.composite.CarEquipmentComposite;
import com.blueflybee.designpatternstudy.composite.DoorFrame;
import com.blueflybee.designpatternstudy.composite.Hood;
import com.blueflybee.designpatternstudy.composite.MoonRoof;
import com.blueflybee.designpatternstudy.composite.Tire;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
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
public class CompositeTest {

  @Test
  public void createCompositeEquipmentStruct() {
    CarEquipment car = createCar();
    verify(car, times(5)).add(any(CarEquipment.class));
    assertEquals(7, car.size());
  }

  @Test
  public void evaluateNetPrice() {
    CarEquipment car = createCar();
    float netPrice = car.getNetPrice();
    assertEquals(12900, netPrice, 0);
  }

  @NonNull
  private CarEquipment createCar() {
    CarEquipment car = spy(new CarEquipmentComposite("car"));
    CarEquipment tire1 = spy(new Tire("tire1"));
    CarEquipment tire2 = spy(new Tire("tire2"));
    CarEquipment tire3 = spy(new Tire("tire3"));
    CarEquipment tire4 = spy(new Tire("tire4"));
    tire1.setNetPrice(100);
    tire2.setNetPrice(100);
    tire3.setNetPrice(100);
    tire4.setNetPrice(100);
    car.add(tire1);
    car.add(tire2);
    car.add(tire3);
    car.add(tire4);

    CarEquipment carBody = spy(new CarEquipmentComposite("carBody"));
    CarEquipment doorFrame = spy(new DoorFrame("door frame"));
    doorFrame.setNetPrice(2000);
    CarEquipment hood = spy(new Hood("hood"));
    hood.setNetPrice(10000);
    CarEquipment moonRoof = spy(new MoonRoof("moon roof"));
    moonRoof.setNetPrice(500);
    carBody.add(doorFrame);
    carBody.add(hood);
    carBody.add(moonRoof);

    car.add(carBody);
    return car;
  }


}
