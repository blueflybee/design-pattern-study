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
public abstract class Equipment {

  private int price;
  private String name;

  public void add(Equipment e) {
  }

  public int size() {
    return 1;
  }

  public abstract void accept(EquipmentVisitor v);

  public void setPrice(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
