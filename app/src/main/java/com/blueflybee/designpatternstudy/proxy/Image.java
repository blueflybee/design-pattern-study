package com.blueflybee.designpatternstudy.proxy;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Image extends Graphic {

  public Image(String fileName) {
  }

  @Override
  public void draw() {
    super.draw();
    System.out.println("Image.draw");
  }

  @Override
  public void handleMouse() {
    super.handleMouse();
    System.out.println("Image.handleMouse");
  }
}
