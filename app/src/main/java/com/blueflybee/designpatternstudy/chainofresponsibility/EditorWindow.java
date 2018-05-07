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
public class EditorWindow implements HelpHandler {
  private static final String TAG = EditorWindow.class.getSimpleName();

  private final HelpHandler mHelpHandler;
  private final HelpTopic mHelpTopic;

  public EditorWindow(HelpHandler helpHandler) {
    this(helpHandler, HelpTopic.HELP_TOPIC_WINDOW);
  }

  public EditorWindow(HelpHandler helpHandler, HelpTopic helpTopic) {
    mHelpHandler = helpHandler;

    mHelpTopic = helpTopic;
  }

  @Override
  public void handleHelp(HelpTopic helpTopic) {
    if (hasHelp(helpTopic)) {
      System.out.println(TAG + "_Show editor window help!!!");
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
