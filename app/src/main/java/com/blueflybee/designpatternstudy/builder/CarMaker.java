package com.blueflybee.designpatternstudy.builder;

import com.blueflybee.designpatternstudy.composite.CarEquipment;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CarMaker {
  public CarEquipment make(CarBuilder builder) {
    builder.buildCar();
    builder.buildTire();
    builder.buildTire();
    builder.buildTire();
    builder.buildTire();
    builder.buildDoorFrame();
    builder.buildHood();
    builder.buildMoonRoof();

    return builder.getCar();
  }
}
