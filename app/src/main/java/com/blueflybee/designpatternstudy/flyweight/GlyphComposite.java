package com.blueflybee.designpatternstudy.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class GlyphComposite extends Glyph {

  private List<Glyph> mGlyphs = new ArrayList<>();

  public GlyphComposite(String name) {
    super(name);
  }

  @Override
  public void add(Glyph g) {
    mGlyphs.add(g);
  }

  @Override
  public int rowSize() {
    return mGlyphs.size();
  }

  @Override
  public int characterSize() {
    int result = 0;
    for (Glyph glyph : mGlyphs) {
      result += glyph.characterSize();
    }
    return result;
  }

  @Override
  public String print() {
    StringBuilder sb = new StringBuilder();
    for (Glyph glyph : mGlyphs) {
      sb.append(glyph.print());
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return "GlyphComposite{" +
        "mGlyphs=" + mGlyphs +
        '}';
  }
}
