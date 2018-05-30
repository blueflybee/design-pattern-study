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
public class PriceVisitor extends EquipmentVisitor {
  private int mTotalPrice = 0;

  public int getTotalPrice() {
    return mTotalPrice;
  }

  @Override
  public void visitPower(Power power) {
    mTotalPrice += power.getPrice();
  }

  @Override
  public void visitCard(Card card) {
    mTotalPrice += card.getPrice();
  }

  @Override
  public void visitFloppyDisk(FloppyDisk floppyDisk) {
    mTotalPrice += floppyDisk.getPrice();
  }

  @Override
  public void visitBus(Bus bus) {
    mTotalPrice += bus.getPrice();
  }

  @Override
  public void visitMainBoard(MainBoard mainBoard) {
    mTotalPrice += mainBoard.getPrice();
  }

  @Override
  public void visitEquipmentComposite(EquipmentComposite composite) {
    mTotalPrice += composite.getPrice();

  }
}
