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
public class UpgradeCarBuilder extends CarBuilder {

  @Override
  public void buildCar() {
    if (mCar == null) {
      mCar = new CarEquipmentComposite("upgrade car");
    }
  }

  @Override
  public void buildTire() {
    mCar.add(new Tire("upgrade tire"));
  }

  @Override
  public void buildDoorFrame() {
    mCar.add(new DoorFrame("upgrade door frame"));
  }

  @Override
  public void buildHood() {
    mCar.add(new Hood("upgrade hood"));
  }

  @Override
  public void buildMoonRoof() {
    mCar.add(new MoonRoof("upgrade moon roof"));
  }
}
