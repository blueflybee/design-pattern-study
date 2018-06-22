package com.blueflybee.designpatternstudy.abstractfactory;

import com.blueflybee.designpatternstudy.composite.CarEquipment;
import com.blueflybee.designpatternstudy.composite.CarEquipmentComposite;
import com.blueflybee.designpatternstudy.composite.DoorFrame;
import com.blueflybee.designpatternstudy.composite.Hood;
import com.blueflybee.designpatternstudy.composite.MoonRoof;
import com.blueflybee.designpatternstudy.composite.Tire;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CarFactory {
  private static CarFactory sCarFactory;

  protected CarFactory() {
  }

  public CarEquipment makeCar() {
    return new CarEquipmentComposite("common car");
  }

  public Tire makeTire() {
    return new Tire("common tire");
  }

  public DoorFrame makeDoorFrame() {
    return new DoorFrame("common door frame");
  }

  public Hood makeHood() {
    return new Hood("common hood");
  }

  public MoonRoof makeMoonRoof() {
    return new MoonRoof("common moon roof");
  }

  public static CarFactory instance() {
    if (sCarFactory == null) {
      sCarFactory = new CarFactory();
    }
    return sCarFactory;
  }
}
