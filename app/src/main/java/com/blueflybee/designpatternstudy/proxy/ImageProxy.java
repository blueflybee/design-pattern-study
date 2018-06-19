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
public class ImageProxy extends Graphic {
  private final String mFileName;
  private Graphic mImage;

  public ImageProxy(String fileName) {
    mFileName = fileName;
  }

  @Override
  public int getExtent() {
    return 100;
  }

  @Override
  public Graphic loadImage(String fileName) {
    System.out.println("ImageProxy.loadImage");
    if (mImage == null) {
      mImage = new Image(fileName);
    }
    return mImage;
  }

  @Override
  public void draw() {
    if (mImage == null) {
      mImage = loadImage(mFileName);
    }
    mImage.draw();
  }

  @Override
  public void handleMouse() {
    if (mImage == null) {
      mImage = loadImage(mFileName);
    }
    mImage.handleMouse();
  }
}
