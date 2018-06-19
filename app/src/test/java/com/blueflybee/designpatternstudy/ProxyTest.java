package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.flyweight.Character;
import com.blueflybee.designpatternstudy.flyweight.Glyph;
import com.blueflybee.designpatternstudy.flyweight.GlyphComposite;
import com.blueflybee.designpatternstudy.flyweight.GlyphFactory;
import com.blueflybee.designpatternstudy.proxy.Graphic;
import com.blueflybee.designpatternstudy.proxy.ImageProxy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
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
public class ProxyTest {

  @Test
  public void createImageProxy_getExtent() {
    Graphic image = spy(new ImageProxy("fileName"));
    int extent = image.getExtent();
    assertEquals(100, extent);
  }

  @Test
  public void imageProxy_loadImage() {
    Graphic image = spy(new ImageProxy("fileName"));
    image.loadImage("fileName");
    verify(image).loadImage(anyString());
  }

  @Test
  public void imageProxy_draw() {
    Graphic image = spy(new ImageProxy("fileName"));
    image.draw();
    verify(image).draw();
  }

  @Test
  public void imageProxy_handleMouse() {
    Graphic image = spy(new ImageProxy("fileName"));
    image.handleMouse();
    verify(image).handleMouse();
  }

}
