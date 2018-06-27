package com.blueflybee.designpatternstudy.prototype;

import com.blueflybee.designpatternstudy.abstractfactory.CarFactory;
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
 *     time   : 2018/06/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class PrototypeCarFactory extends CarFactory {
  private final Tire mTire;
  private final DoorFrame mDoorFrame;
  private final Hood mHood;
  private final MoonRoof mMoonRoof;

  public PrototypeCarFactory(Tire tire, DoorFrame doorFrame, Hood hood, MoonRoof moonRoof) {
    mTire = tire;
    mDoorFrame = doorFrame;
    mHood = hood;
    mMoonRoof = moonRoof;
  }

  @Override
  public CarEquipment makeCar() {
    return new CarEquipmentComposite(mTire.getName().replace("tire", "car"));
  }

  @Override
  public Tire makeTire() {
    return mTire.clone();
  }

  @Override
  public DoorFrame makeDoorFrame() {
    return mDoorFrame.clone();
  }

  @Override
  public Hood makeHood() {
    return mHood.clone();
  }

  @Override
  public MoonRoof makeMoonRoof() {
    return mMoonRoof.clone();
  }
}
