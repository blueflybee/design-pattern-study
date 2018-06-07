package com.blueflybee.designpatternstudy.decorator;

import android.util.Base64;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Base64Coder extends CoderDecorator {
  public Base64Coder(DataStream stream) {
    super(stream);
  }

  @Override
  public String write(String content) {
    String encode = new BASE64Encoder().encode(content.getBytes());
    System.out.println("Base64Coder.write = " + content + " ——> " + encode);
    return mDataStream.write(encode);
  }

  @Override
  public String read(String content) {
    try {
      byte[] bytes = new BASE64Decoder().decodeBuffer(content);
      String decode = new String(bytes);
      System.out.println("Base64Coder.read = " + content + " ——> " + decode);
      return mDataStream.read(decode);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }
}
