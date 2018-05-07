package com.blueflybee.designpatternstudy.chainofresponsibility;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class EditorDialog implements HelpHandler {
  private static final String TAG = EditorDialog.class.getSimpleName();
  private final HelpHandler mHelpHandler;
  private final HelpTopic mHelpTopic;

  public EditorDialog(HelpHandler helpHandler) {
    this(helpHandler, HelpTopic.NO_HELP_TOPIC);
  }

  public EditorDialog(HelpHandler helpHandler, HelpTopic helpTopic) {
    this.mHelpHandler = helpHandler;
    mHelpTopic = helpTopic;
  }

  @Override
  public void handleHelp(HelpTopic helpTopic) {
    if (hasHelp(helpTopic)) {
      System.out.println(TAG + "_Show editor dialog help!!!");
    } else {
      if (mHelpHandler != null) {
        mHelpHandler.handleHelp(helpTopic);
      }
    }

  }

  private boolean hasHelp(HelpTopic helpTopic) {
    return mHelpTopic == helpTopic;
  }
}
