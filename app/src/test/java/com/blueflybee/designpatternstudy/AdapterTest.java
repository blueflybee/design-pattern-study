package com.blueflybee.designpatternstudy;

import android.widget.TextView;

import com.blueflybee.designpatternstudy.adapter.IImageShape;
import com.blueflybee.designpatternstudy.adapter.ImageShape;
import com.blueflybee.designpatternstudy.adapter.ImageViewTool;
import com.blueflybee.designpatternstudy.adapter.Shape;
import com.blueflybee.designpatternstudy.adapter.TextShape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   : Test command design pattern
 *     version: 1.0
 * </pre>
 */
public class AdapterTest {

  @Test
  public void objectAdapter_setText() {
    TextView textView = mock(TextView.class);
    Shape shape = spy(new TextShape(textView));
    shape.setText("test");
    verify(textView).setText("test");
  }

  @Test
  public void objectAdapter_setEnable() {
    TextView textView = mock(TextView.class);
    Shape shape = spy(new TextShape(textView));
    shape.setEnable(true);
    verify(textView).setEnabled(true);
  }

  @Test
  public void classAdapter_setBackground() {
    IImageShape shape = spy(new ImageShape());
    ImageViewTool tool = (ImageViewTool) shape;
    shape.setBackground();
    verify(shape).setBackground();

  }



}
