package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.flyweight.Character;
import com.blueflybee.designpatternstudy.flyweight.Glyph;
import com.blueflybee.designpatternstudy.flyweight.GlyphComposite;
import com.blueflybee.designpatternstudy.flyweight.GlyphFactory;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
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
public class FlyweightTest {

  @Test
  public void createColumnStruct_rowSize() {
    Glyph column = spy(new GlyphComposite("column"));
    Glyph row1 = spy(new GlyphComposite("row1"));
    Glyph row2 = spy(new GlyphComposite("row2"));
    Glyph row3 = spy(new GlyphComposite("row3"));
    Glyph row4 = spy(new GlyphComposite("row4"));
    Glyph row5 = spy(new GlyphComposite("row5"));

    column.add(row1);
    column.add(row2);
    column.add(row3);
    column.add(row4);
    column.add(row5);
    verify(column, times(5)).add(any(Glyph.class));
    assertEquals(5, column.rowSize());
  }

  @Test
  public void createColumnStruct_size() {
    Glyph column = spy(new GlyphComposite("column"));
    Glyph row1 = spy(new GlyphComposite("row1"));
    row1.add(spy(new Character("你")));
    row1.add(spy(new Character("好")));
    row1.add(spy(new Character("c")));
    Glyph row2 = spy(new GlyphComposite("row2"));
    row2.add(spy(new Character("d")));
    row2.add(spy(new Character("e")));
    row2.add(spy(new Character("f")));
    Glyph row3 = spy(new GlyphComposite("row3"));
    row3.add(spy(new Character("g")));
    row3.add(spy(new Character("h")));
    row3.add(spy(new Character("i")));


    column.add(row1);
    column.add(row2);
    column.add(row3);
    verify(column, times(3)).add(any(Glyph.class));
    verify(row1, times(3)).add(any(Character.class));
    assertEquals(3, column.rowSize());
    assertEquals(9, column.characterSize());
  }

  @Test
  public void factoryCreateColumn() {
    Glyph column = GlyphFactory.createColumn("column");
    assertNotNull(column);
  }

  @Test
  public void factoryCreateRow() {
    Glyph row = GlyphFactory.createRow("row");
    assertNotNull(row);
  }

  @Test
  public void factoryCreateCharacter() {
    Glyph a = GlyphFactory.createCharacter("a");
    assertNotNull(a);

    Glyph b = GlyphFactory.createCharacter("b");
    assertNotNull(b);

    assertNotSame(a, b);

    Glyph a1 = GlyphFactory.createCharacter("a");
    assertNotNull(a1);

    assertSame(a, a1);

  }

  @Test
  public void factoryCreateEmptyCharacter() {
    Glyph emp = GlyphFactory.createCharacter(" ");
    assertNotNull(emp);
  }

  @Test
  public void factoryLoadCharacters() {
    String paragraph = "Does one need to begin a diary with background information? This was not a question which crossed my mind when I was eleven—at least not that I recall. And in spite of the great shitload of English courses I’ve taken in my time, I don’t recall ever attending one which covered the Protocol of Journals. Footnotes, synopses, outlines, the proper placement of modifiers, the correct form of the business letter—these were all things in which I took instruction. But on how to start a diary I am as blank as I am, say, on how to continue your life after its light just went out. ";
    Glyph column = GlyphFactory.load(paragraph);
    assertNotNull(column);

    String doc = column.print();
    assertEquals(paragraph, doc);
  }

//  @Test
//  public void factoryLoadZhCharacters() {
//    String paragraph = "这片沙漠堪称所有沙漠中的完美典型，巨大无比，延及天际，朝任何一个方向望去都无边无际。\n沙漠白茫茫的，十分刺眼，没有水源，没有生气，惟有隐约闪现的群山的雾霭，只见群山散布在地平线上，那里的鬼草让人做迷梦、噩梦和死亡。\n偶尔出现的墓碑标记指明了道路，因为穿过厚厚碱层的被覆盖的路径曾经是条公路，客运车和布卡（注：布卡，bucka，一种马车。\n这是斯蒂芬·金的生造词。斯蒂芬·金在“黑暗塔”生造了大量的词汇表示他虚构世界里的事物。有些生造词的具体涵义令读者琢磨不透，甚至成为不少“黑暗塔”迷热烈讨论的话题。在下文中这种情况还很多。）\n过去都走这条路。后来，世界滚滚向前。这个世界被腾空了。";
//    Glyph column = GlyphFactory.load(paragraph);
//    assertNotNull(column);
//  }


}
