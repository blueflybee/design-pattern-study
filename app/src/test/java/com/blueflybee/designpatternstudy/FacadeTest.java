package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.decorator.Base64Coder;
import com.blueflybee.designpatternstudy.decorator.CoderDecorator;
import com.blueflybee.designpatternstudy.decorator.DataStream;
import com.blueflybee.designpatternstudy.decorator.FileDataStream;
import com.blueflybee.designpatternstudy.decorator.GZIPCoder;
import com.blueflybee.designpatternstudy.facade.CompilerFacade;
import com.blueflybee.designpatternstudy.facade.NodeBuilder;
import com.blueflybee.designpatternstudy.facade.Parser;
import com.blueflybee.designpatternstudy.facade.Scanner;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
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
public class FacadeTest {

  @Test
  public void createFacade() {
    CompilerFacade facade = spy(new CompilerFacade());
    facade.compile();
    verify(facade).compile();
  }

  @Test
  public void parse() {
    Scanner scanner = spy(new Scanner());
    Parser parser = spy(new Parser());
    parser.setScanner(scanner);

    NodeBuilder builder = spy(new NodeBuilder());

    parser.parse(builder);
    verify(parser).parse(any(NodeBuilder.class));
    verify(builder).build();
    verify(scanner).scan();

  }
//
//  @Test
//  public void gzipDecoratorUncompress_read() throws IOException {
//
//    DataStream stream1 = spy(new FileDataStream(FILE_PATH));
//    Base64Coder base64Stream1 = spy(new Base64Coder(stream1));
//    GZIPCoder gzipStream1 = spy(new GZIPCoder(base64Stream1));
//
//    String result = gzipStream1.write(STR_CONTENT);
//
//    DataStream stream = spy(new FileDataStream(FILE_PATH));
//    GZIPCoder gzipStream = spy(new GZIPCoder(stream));
//    Base64Coder base64Stream = spy(new Base64Coder(gzipStream));
//
//    base64Stream.read(result);
//    verify(base64Stream).read(anyString());
//    verify(gzipStream).read(anyString());
//    verify(stream).read(anyString());
//
//  }
//
//  @Test
//  public void gzipBase64gzipBase64Base64_write_read() {
//    //运行时动态自由组合编码解码方式
//    DataStream stream = new FileDataStream(FILE_PATH);
//    DataStream gzipStream = new GZIPCoder(new Base64Coder(new GZIPCoder(new Base64Coder(new Base64Coder(stream)))));
//
//    String result = gzipStream.write(STR_CONTENT);
//
//    Base64Coder base64Coder = new Base64Coder(new Base64Coder(new GZIPCoder(new Base64Coder(new GZIPCoder(stream)))));
//    String read = base64Coder.read(result);
//
//    assertEquals(STR_CONTENT, read);
//
//  }

}
