package com.blueflybee.designpatternstudy.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CarEquipmentComposite extends CarEquipment {

  private List<CarEquipment> mEquipments = new ArrayList<>();

  public CarEquipmentComposite(String name) {
    super(name);
  }

  @Override
  public void add(CarEquipment e) {
    mEquipments.add(e);
  }

  @Override
  public float getNetPrice() {
    float result = 0;
    for (CarEquipment e : mEquipments) {
      result += e.getNetPrice();
    }
    return result;
  }

  @Override
  public int size() {
    int result = 0;
    for (CarEquipment e : mEquipments) {
      result += e.size();
    }
    return result;
  }
}
