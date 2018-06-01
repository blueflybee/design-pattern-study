package com.blueflybee.designpatternstudy.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/01
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ImageShape extends ImageViewTool implements IImageShape {

  @Override
  public void setBackground() {
    super.setBackgroundResource(0);
  }

  @Override
  public void drawContent() {
    super.draw();
  }

}
