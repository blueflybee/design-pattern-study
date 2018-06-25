package com.blueflybee.designpatternstudy.builder;

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
 *     time   : 2018/06/25
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CarBuilder {

  protected CarEquipment mCar;

  public void buildCar() {
    if (mCar == null) {
      mCar = new CarEquipmentComposite("common car");
    }
  }

  public void buildTire() {
    mCar.add(new Tire("common tire"));
  }

  public void buildDoorFrame() {
    mCar.add(new DoorFrame("common door frame"));
  }

  public void buildHood() {
    mCar.add(new Hood("common hood"));
  }

  public void buildMoonRoof() {
    mCar.add(new MoonRoof("common moon roof"));
  }

  public CarEquipment getCar() {
    return mCar;
  }
}
