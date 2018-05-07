package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.chainofresponsibility.EditorApplication;
import com.blueflybee.designpatternstudy.chainofresponsibility.EditorButton;
import com.blueflybee.designpatternstudy.chainofresponsibility.EditorDialog;
import com.blueflybee.designpatternstudy.chainofresponsibility.EditorWindow;
import com.blueflybee.designpatternstudy.chainofresponsibility.HelpHandler;

import org.junit.Test;

import static com.blueflybee.designpatternstudy.chainofresponsibility.HelpTopic.HELP_TOPIC_APPLICATION;
import static com.blueflybee.designpatternstudy.chainofresponsibility.HelpTopic.HELP_TOPIC_BUTTON;
import static com.blueflybee.designpatternstudy.chainofresponsibility.HelpTopic.HELP_TOPIC_DIALOG;
import static com.blueflybee.designpatternstudy.chainofresponsibility.HelpTopic.HELP_TOPIC_WINDOW;
import static org.mockito.Mockito.*;


/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ChainOfResponsibilityTest {

  @Test
  public void chainOfHandleHelp_isInvoked() throws Exception {
    HelpHandler application = spy(new EditorApplication());
    HelpHandler window = spy(new EditorWindow(application, HELP_TOPIC_WINDOW));
    HelpHandler dialog = spy(new EditorDialog(window));
    HelpHandler button = spy(new EditorButton(dialog));

    button.handleHelp(HELP_TOPIC_BUTTON);

    verify(button).handleHelp(HELP_TOPIC_BUTTON);
    verify(dialog).handleHelp(HELP_TOPIC_BUTTON);
    verify(window).handleHelp(HELP_TOPIC_BUTTON);
    verify(application).handleHelp(HELP_TOPIC_BUTTON);
  }

  @Test
  public void buttonHandleHelp_isInvoked() throws Exception {
    HelpHandler application = spy(new EditorApplication());
    HelpHandler window = spy(new EditorWindow(application, HELP_TOPIC_WINDOW));
    HelpHandler dialog = spy(new EditorDialog(window));
    EditorButton button = spy(new EditorButton(dialog, HELP_TOPIC_BUTTON));

    button.handleHelp(HELP_TOPIC_BUTTON);

    verify(button).handleHelp(HELP_TOPIC_BUTTON);
    verify(dialog, never()).handleHelp(HELP_TOPIC_BUTTON);
    verify(window, never()).handleHelp(HELP_TOPIC_BUTTON);
    verify(application, never()).handleHelp(HELP_TOPIC_BUTTON);
  }

  @Test
  public void dialogHandleHelp_isInvoked() throws Exception {
    HelpHandler application = spy(new EditorApplication());
    HelpHandler window = spy(new EditorWindow(application, HELP_TOPIC_WINDOW));
    HelpHandler dialog = spy(new EditorDialog(window, HELP_TOPIC_DIALOG));
    EditorButton button = spy(new EditorButton(dialog, HELP_TOPIC_BUTTON));

    button.handleHelp(HELP_TOPIC_DIALOG);

    verify(button).handleHelp(HELP_TOPIC_DIALOG);
    verify(dialog).handleHelp(HELP_TOPIC_DIALOG);
    verify(window, never()).handleHelp(HELP_TOPIC_DIALOG);
    verify(application, never()).handleHelp(HELP_TOPIC_DIALOG);
  }

  @Test
  public void windowHandleHelp_isInvoked() throws Exception {
    HelpHandler application = spy(new EditorApplication());
    HelpHandler window = spy(new EditorWindow(application, HELP_TOPIC_WINDOW));
    HelpHandler dialog = spy(new EditorDialog(window, HELP_TOPIC_DIALOG));
    EditorButton button = spy(new EditorButton(dialog, HELP_TOPIC_BUTTON));

    button.handleHelp(HELP_TOPIC_WINDOW);

    verify(button).handleHelp(HELP_TOPIC_WINDOW);
    verify(dialog).handleHelp(HELP_TOPIC_WINDOW);
    verify(window).handleHelp(HELP_TOPIC_WINDOW);
    verify(application, never()).handleHelp(HELP_TOPIC_WINDOW);
  }

  @Test
  public void applicationHandleHelp_isInvoked() throws Exception {
    HelpHandler application = spy(new EditorApplication());
    HelpHandler window = spy(new EditorWindow(application, HELP_TOPIC_WINDOW));
    HelpHandler dialog = spy(new EditorDialog(window, HELP_TOPIC_DIALOG));
    EditorButton button = spy(new EditorButton(dialog, HELP_TOPIC_BUTTON));

    button.handleHelp(HELP_TOPIC_APPLICATION);

    verify(button).handleHelp(HELP_TOPIC_APPLICATION);
    verify(dialog).handleHelp(HELP_TOPIC_APPLICATION);
    verify(window).handleHelp(HELP_TOPIC_APPLICATION);
    verify(application).handleHelp(HELP_TOPIC_APPLICATION);
  }
}
