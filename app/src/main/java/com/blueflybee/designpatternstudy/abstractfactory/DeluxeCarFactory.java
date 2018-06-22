package com.blueflybee.designpatternstudy.abstractfactory;

import com.blueflybee.designpatternstudy.composite.CarEquipment;
import com.blueflybee.designpatternstudy.composite.CarEquipmentComposite;
import com.blueflybee.designpatternstudy.composite.DeluxeDoorFrame;
import com.blueflybee.designpatternstudy.composite.DeluxeHood;
import com.blueflybee.designpatternstudy.composite.DeluxeMoonRoof;
import com.blueflybee.designpatternstudy.composite.DeluxeTire;
import com.blueflybee.designpatternstudy.composite.DoorFrame;
import com.blueflybee.designpatternstudy.composite.Hood;
import com.blueflybee.designpatternstudy.composite.MoonRoof;
import com.blueflybee.designpatternstudy.composite.Tire;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class DeluxeCarFactory extends CarFactory {
  private static CarFactory sDeluxeCarFactory;

  private DeluxeCarFactory() {
    super();
  }

  public CarEquipment makeCar() {
    return new CarEquipmentComposite("deluxe car");
  }

  public Tire makeTire() {
    return new DeluxeTire("deluxe tire");
  }

  public DoorFrame makeDoorFrame() {
    return new DeluxeDoorFrame("deluxe door frame");
  }

  public Hood makeHood() {
    return new DeluxeHood("deluxe hood");
  }

  public MoonRoof makeMoonRoof() {
    return new DeluxeMoonRoof("deluxe moon roof");
  }


  public static CarFactory instance() {
    if (sDeluxeCarFactory == null) {
      sDeluxeCarFactory = new DeluxeCarFactory();
    }
    return sDeluxeCarFactory;
  }
}
