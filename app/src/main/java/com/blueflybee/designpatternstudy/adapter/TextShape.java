package com.blueflybee.designpatternstudy.adapter;

import android.widget.TextView;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/01
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TextShape extends Shape {
  private final TextView mTextView;

  public TextShape(TextView textView) {
    mTextView = textView;
  }

  @Override
  public void setText(String text) {
    super.setText(text);
    mTextView.setText(text);
  }

  @Override
  public void setEnable(boolean enable) {
    super.setEnable(enable);
    mTextView.setEnabled(enable);
  }
}
