package com.blueflybee.designpatternstudy.abstractfactory;

import com.blueflybee.designpatternstudy.composite.CarEquipment;
import com.blueflybee.designpatternstudy.composite.CarEquipmentComposite;
import com.blueflybee.designpatternstudy.composite.DoorFrame;
import com.blueflybee.designpatternstudy.composite.Hood;
import com.blueflybee.designpatternstudy.composite.MoonRoof;
import com.blueflybee.designpatternstudy.composite.Tire;
import com.blueflybee.designpatternstudy.composite.UpgradeDoorFrame;
import com.blueflybee.designpatternstudy.composite.UpgradeHood;
import com.blueflybee.designpatternstudy.composite.UpgradeMoonRoof;
import com.blueflybee.designpatternstudy.composite.UpgradeTire;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class UpgradeCarFactory extends CarFactory {

  @Override
  public CarEquipment makeCar() {
    return new CarEquipmentComposite("upgrade car");
  }

  @Override
  public UpgradeTire makeTire() {
    return new UpgradeTire("upgrade tire");
  }

  @Override
  public DoorFrame makeDoorFrame() {
    return new UpgradeDoorFrame("upgrade door frame");
  }

  @Override
  public Hood makeHood() {
    return new UpgradeHood("upgrade hood");
  }

  @Override
  public MoonRoof makeMoonRoof() {
    return new UpgradeMoonRoof("upgrade moon roof");
  }
}
