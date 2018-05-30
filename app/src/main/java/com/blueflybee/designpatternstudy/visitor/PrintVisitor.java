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
public class PrintVisitor extends EquipmentVisitor {
  public static final String LINE = "---------------------------------------";
  private StringBuilder mSb;
  private int mTotalPrice;

  public PrintVisitor() {
    mSb = new StringBuilder();
    mSb.append(LINE).append("\n");
  }

  @Override
  public void visitPower(Power power) {
    mSb.append(power.getName()).append("  ").append(power.getPrice()).append("元").append("\n");
    mTotalPrice += power.getPrice();
  }

  @Override
  public void visitCard(Card card) {
    mSb.append(card.getName()).append("  ").append(card.getPrice()).append("元").append("\n");
    mTotalPrice += card.getPrice();
  }

  @Override
  public void visitFloppyDisk(FloppyDisk floppyDisk) {
    mSb.append(floppyDisk.getName()).append("  ").append(floppyDisk.getPrice()).append("元").append("\n");
    mTotalPrice += floppyDisk.getPrice();
  }

  @Override
  public void visitBus(Bus bus) {
    mSb.append(bus.getName()).append("  ").append(bus.getPrice()).append("元").append("\n");
    mTotalPrice += bus.getPrice();
  }

  @Override
  public void visitMainBoard(MainBoard mainBoard) {
    mSb.append(mainBoard.getName()).append("  ").append(mainBoard.getPrice()).append("元").append("\n");
    mTotalPrice += mainBoard.getPrice();
  }

  @Override
  public void visitEquipmentComposite(EquipmentComposite composite) {
    mTotalPrice += composite.getPrice();
    int price = "总计".equals(composite.getName()) ? mTotalPrice : composite.getPrice();
    mSb.append(composite.getName()).append("  ").append(price).append("元").append("\n");
  }

  public void print() {
    mSb.append(LINE);
    System.out.println(mSb);
  }
}
