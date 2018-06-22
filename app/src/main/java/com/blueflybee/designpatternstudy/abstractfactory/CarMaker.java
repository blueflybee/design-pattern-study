package com.blueflybee.designpatternstudy.abstractfactory;

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
  public CarEquipment make(CarFactory factory) {
    CarEquipment car = factory.makeCar();
    car.add(factory.makeTire());
    car.add(factory.makeTire());
    car.add(factory.makeTire());
    car.add(factory.makeTire());

    car.add(factory.makeDoorFrame());
    car.add(factory.makeHood());
    car.add(factory.makeMoonRoof());

    return car;
  }
}
