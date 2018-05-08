package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.command.Command;
import com.blueflybee.designpatternstudy.command.CommandApplication;
import com.blueflybee.designpatternstudy.command.Document;
import com.blueflybee.designpatternstudy.command.MacroCommand;
import com.blueflybee.designpatternstudy.command.OpenCommand;
import com.blueflybee.designpatternstudy.command.PasteCommand;
import com.blueflybee.designpatternstudy.command.Receiver;
import com.blueflybee.designpatternstudy.command.SimpleCommand;
import com.blueflybee.designpatternstudy.command.SimpleReceiver;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


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
    Receiver receiver = mock(Receiver.class);
    Command command = spy(new SimpleCommand(receiver));

    command.execute();

    verify(command).execute();
    verify(receiver).action();
  }

  @Test
  public void openCommand_isExecute() throws Exception {
    CommandApplication application = mock(CommandApplication.class);
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

  @Test
  public void macroCommand_addCommand() throws Exception {

    Command command = mock(Command.class);
    MacroCommand macroCommand = spy(MacroCommand.class);

    assertEquals(0, macroCommand.size());

    macroCommand.add(command);

    verify(macroCommand).add(any(Command.class));

    assertEquals(1, macroCommand.size());


  }

  @Test
  public void macroCommand_removeCommand() throws Exception {

    MacroCommand macroCommand = spy(MacroCommand.class);

    macroCommand.add(any(Command.class));

    assertEquals(1, macroCommand.size());

    macroCommand.remove(any(Command.class));
    verify(macroCommand).remove(any(Command.class));
    assertEquals(0, macroCommand.size());

  }

  @Test
  public void macroCommand_isExecute() throws Exception {

    MacroCommand macroCommand = spy(MacroCommand.class);

    Command command1 = mock(Command.class);
    Command command2 = mock(Command.class);
    Command command3 = mock(Command.class);
    Command command4 = mock(Command.class);
    Command command5 = mock(Command.class);

    macroCommand.add(command1);
    macroCommand.add(command2);
    macroCommand.add(command3);
    macroCommand.add(command4);
    macroCommand.add(command5);

    assertEquals(5, macroCommand.size());

    macroCommand.execute();

    verify(macroCommand).execute();
    verify(command1).execute();
    verify(command2).execute();
    verify(command3).execute();
    verify(command4).execute();
    verify(command5).execute();

  }

}
