package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.command.Command;
import com.blueflybee.designpatternstudy.command.CommandApplication;
import com.blueflybee.designpatternstudy.command.Document;
import com.blueflybee.designpatternstudy.command.OpenCommand;
import com.blueflybee.designpatternstudy.command.PasteCommand;
import com.blueflybee.designpatternstudy.command.Receiver;
import com.blueflybee.designpatternstudy.command.SimpleCommand;
import com.blueflybee.designpatternstudy.command.SimpleReceiver;

import org.junit.Test;

import static org.mockito.Matchers.any;
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
public class CommandTest {

  @Test
  public void simpleCommand_isExecute() throws Exception {
    Receiver receiver = spy(new SimpleReceiver());
    Command command = spy(new SimpleCommand(receiver));

    command.execute();

    verify(command).execute();
    verify(receiver).action();
  }

  @Test
  public void openCommand_isExecute() throws Exception {
    CommandApplication application = spy(new CommandApplication());
    Command command = spy(new OpenCommand(application));

    command.execute();

    verify(command).execute();
    verify(application).add(any(Document.class));
  }

  @Test
  public void pasteCommand_isExecute() throws Exception {

    Document document = mock(Document.class);
    Command command = spy(new PasteCommand(document));

    command.execute();

    verify(command).execute();
    verify(document).paste();
  }

}
