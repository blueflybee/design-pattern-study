package com.blueflybee.designpatternstudy.factorymethod;

import com.blueflybee.designpatternstudy.abstractfactory.CarFactory;
import com.blueflybee.designpatternstudy.composite.CarEquipment;
import com.blueflybee.designpatternstudy.composite.CarEquipmentComposite;
import com.blueflybee.designpatternstudy.composite.CrossCountryTire;
import com.blueflybee.designpatternstudy.composite.Tire;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CrossCountryCarFactory extends CarFactory{
  private static CarFactory sCrossCountryCarFactory;

  private CrossCountryCarFactory() {
    super();
  }

  @Override
  public CarEquipment makeCar() {
    return new CarEquipmentComposite("cross-country car");
  }

  @Override
  public Tire makeTire() {
    return new CrossCountryTire("cross-country tire");
  }

  public static CarFactory instance() {
    if (sCrossCountryCarFactory == null) {
      sCrossCountryCarFactory = new CrossCountryCarFactory();
    }
    return sCrossCountryCarFactory;
  }
}
