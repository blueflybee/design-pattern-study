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
public class CarEquipment {

  protected float netPrice;

  public CarEquipment(String name) {
  }

  public void add(CarEquipment e) {
  }

  public int size() {
    return 1;
  }

  public float getNetPrice() {
    return netPrice;
  }

  public void setNetPrice(float netPrice) {
    this.netPrice = netPrice;
  }
}
