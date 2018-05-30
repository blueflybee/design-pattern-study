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
public abstract class EquipmentVisitor {

  public abstract void visitPower(Power power);

  public abstract void visitCard(Card card);

  public abstract void visitFloppyDisk(FloppyDisk floppyDisk);

  public abstract void visitBus(Bus bus);

  public abstract void visitMainBoard(MainBoard mainBoard);

  public abstract void visitEquipmentComposite(EquipmentComposite composite);
}
