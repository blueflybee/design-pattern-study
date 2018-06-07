package com.blueflybee.designpatternstudy.decorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/06/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class GZIPCoder extends CoderDecorator {
  private static final String GZIP_ENCODE_UTF_8 = "UTF-8";
  private static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";

  public GZIPCoder(DataStream stream) {
    super(stream);
  }

  @Override
  public String write(String content) {
    try {
      String compressStr = new String(compress(content), GZIP_ENCODE_ISO_8859_1);
//      String compressEncode = new BASE64Encoder().encode(compress(content));
      System.out.println("GZIPCoder.write = " + content + " ——> " + compressStr);
      return mDataStream.write(compressStr);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return null;
    }

  }

  @Override
  public String read(String content) {
    try {
      //      String uncompress = uncompressToString(new BASE64Decoder().decodeBuffer(content));
      String uncompress = uncompressToString(content.getBytes(GZIP_ENCODE_ISO_8859_1), GZIP_ENCODE_ISO_8859_1);
      System.out.println("GZIPCoder.read = " + content + " ——> " + uncompress);
      return mDataStream.read(uncompress);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }

  private byte[] compress(String str, String encoding) {
    if (str == null || str.length() == 0) {
      return null;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    GZIPOutputStream gzip;
    try {
      gzip = new GZIPOutputStream(out);
      gzip.write(str.getBytes(encoding));
      gzip.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return out.toByteArray();
  }

  private byte[] compress(String str) {
    return compress(str, GZIP_ENCODE_UTF_8);
  }

//  private String uncompress(byte[] bytes, String encoding) {
//    if (bytes == null || bytes.length == 0) {
//      return null;
//    }
//    ByteArrayOutputStream out = new ByteArrayOutputStream();
//    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
//    try {
//      GZIPInputStream ungzip = new GZIPInputStream(in);
//      byte[] buffer = new byte[256];
//      int n;
//      while ((n = ungzip.read(buffer)) >= 0) {
//        out.write(buffer, 0, n);
//      }
//      return out.toString(encoding);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    return null;
//  }


  private String uncompressToString(byte[] bytes, String encoding) {
    if (bytes == null || bytes.length == 0) {
      return null;
    }
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    try {
      GZIPInputStream ungzip = new GZIPInputStream(in);
      byte[] buffer = new byte[256];
      int n;
      while ((n = ungzip.read(buffer)) >= 0) {
        out.write(buffer, 0, n);
      }
      return out.toString(encoding);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private String uncompressToString(byte[] bytes) {
    return uncompressToString(bytes, GZIP_ENCODE_UTF_8);
  }

}
