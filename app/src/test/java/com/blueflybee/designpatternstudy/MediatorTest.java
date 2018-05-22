package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.command.Command;
import com.blueflybee.designpatternstudy.command.Document;
import com.blueflybee.designpatternstudy.command.PasteCommand;
import com.blueflybee.designpatternstudy.mediator.ViewMediator;
import com.blueflybee.designpatternstudy.mediator.EntryField;
import com.blueflybee.designpatternstudy.mediator.FontViewMediator;
import com.blueflybee.designpatternstudy.mediator.Widget;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
public class MediatorTest {

  @Test
  public void showDialog_isExecute() throws Exception {
    ViewMediator viewMediator = spy(new FontViewMediator());
    viewMediator.showDialog();
    verify(viewMediator).showDialog();
    verify(viewMediator).createWidgets();
  }

  @Test
  public void EntryFieldChange_directorChange() throws Exception {
    ViewMediator viewMediator = spy(new FontViewMediator());
    Widget widget = spy(new EntryField(viewMediator));
    widget.changed();
    verify(widget).changed();
    verify(viewMediator).onWidgetChanged(widget);
  }

  @Test
  public void pasteCommand_isExecute() throws Exception {

    Document document = mock(Document.class);
    Command command = spy(new PasteCommand(document));

    command.execute();

    verify(command).execute();
    verify(document).paste();

  }
//
//  @Test
//  public void macroCommand_addCommand() throws Exception {
//
//    Command command = mock(Command.class);
//    MacroCommand macroCommand = spy(MacroCommand.class);
//
//    assertEquals(0, macroCommand.size());
//
//    macroCommand.add(command);
//
//    verify(macroCommand).add(any(Command.class));
//
//    assertEquals(1, macroCommand.size());
//
//
//  }
//
//  @Test
//  public void macroCommand_removeCommand() throws Exception {
//
//    MacroCommand macroCommand = spy(MacroCommand.class);
//
//    macroCommand.add(any(Command.class));
//
//    assertEquals(1, macroCommand.size());
//
//    macroCommand.remove(any(Command.class));
//    verify(macroCommand).remove(any(Command.class));
//    assertEquals(0, macroCommand.size());
//
//  }
//
//  @Test
//  public void macroCommand_isExecute() throws Exception {
//
//    MacroCommand macroCommand = spy(MacroCommand.class);
//
//    Command command1 = mock(Command.class);
//    Command command2 = mock(Command.class);
//    Command command3 = mock(Command.class);
//    Command command4 = mock(Command.class);
//    Command command5 = mock(Command.class);
//
//    macroCommand.add(command1);
//    macroCommand.add(command2);
//    macroCommand.add(command3);
//    macroCommand.add(command4);
//    macroCommand.add(command5);
//
//    assertEquals(5, macroCommand.size());
//
//    macroCommand.execute();
//
//    verify(macroCommand).execute();
//    verify(command1).execute();
//    verify(command2).execute();
//    verify(command3).execute();
//    verify(command4).execute();
//    verify(command5).execute();
//
//  }

}
