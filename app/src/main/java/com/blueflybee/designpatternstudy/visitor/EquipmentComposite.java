package com.blueflybee.designpatternstudy.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/30
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class EquipmentComposite extends Equipment {

  private List<Equipment> mEquipments = new ArrayList<>();

  @Override
  public void add(Equipment e) {
    mEquipments.add(e);
  }

  @Override
  public int size() {
    int result = 0;
    for (Equipment e : mEquipments) {
      result += e.size();
    }
    return result;
  }

  @Override
  public void accept(EquipmentVisitor v) {
    for (Equipment e : mEquipments) {
      e.accept(v);
    }
    v.visitEquipmentComposite(this);
  }

}
