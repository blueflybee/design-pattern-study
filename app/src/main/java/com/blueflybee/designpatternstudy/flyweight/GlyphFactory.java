package com.blueflybee.designpatternstudy.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class GlyphFactory {

  private static final Map<String, Character> sCharacterMap = new HashMap<>();

  public static GlyphComposite createColumn(String name) {
    return new GlyphComposite(name);
  }

  public static GlyphComposite createRow(String name) {
    return new GlyphComposite(name);
  }

  public static Character createCharacter(String c) {
    Character character = sCharacterMap.get(c);
    if (character == null) {
      character = new Character(c);
      sCharacterMap.put(c, character);
    }
    System.out.println("sCharacterMap = " + sCharacterMap.keySet());
    System.out.println("sCharacterMap = " + sCharacterMap.size());
    return character;
  }

  public static Glyph load(String content) {
    GlyphComposite column = createColumn("column");
    GlyphComposite row = createRow("row");
    column.add(row);
    char[] chars = content.toCharArray();
//    System.out.println("chars.length = " + chars.length);
    for (char aChar : chars) {
      row.add(createCharacter(String.valueOf(aChar)));
    }
    return column;
  }
}
