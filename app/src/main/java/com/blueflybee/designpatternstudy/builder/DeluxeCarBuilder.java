package com.blueflybee.designpatternstudy.builder;

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
public class DeluxeCarBuilder extends CarBuilder {

  @Override
  public void buildCar() {
    if (mCar == null) {
      mCar = new CarEquipmentComposite("deluxe car");
    }
  }

  @Override
  public void buildTire() {
    mCar.add(new Tire("deluxe tire"));
  }

  @Override
  public void buildDoorFrame() {
    mCar.add(new DoorFrame("deluxe door frame"));
  }

  @Override
  public void buildHood() {
    mCar.add(new Hood("deluxe hood"));
  }

  @Override
  public void buildMoonRoof() {
    mCar.add(new MoonRoof("deluxe moon roof"));
  }
}
