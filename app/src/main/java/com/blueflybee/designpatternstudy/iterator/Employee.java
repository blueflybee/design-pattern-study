package com.blueflybee.designpatternstudy.iterator;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Employee {
  private String id;
  private String name;

  public Employee() {
  }

  public Employee(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
