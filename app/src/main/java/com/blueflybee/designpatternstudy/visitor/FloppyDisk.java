package com.blueflybee.designpatternstudy.visitor;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/30
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class FloppyDisk extends Equipment {
  @Override
  public void accept(EquipmentVisitor v) {
    v.visitFloppyDisk(this);
  }
}
