package com.blueflybee.designpatternstudy.chainofresponsibility;

import static com.blueflybee.designpatternstudy.chainofresponsibility.HelpTopic.NO_HELP_TOPIC;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class EditorButton implements HelpHandler {
  private static final String TAG = EditorButton.class.getSimpleName();
  private final HelpHandler mHelpHandler;
  private final HelpTopic mHelpTopic;

  public EditorButton(HelpHandler helpHandler) {
    this(helpHandler, NO_HELP_TOPIC);
  }

  public EditorButton(HelpHandler helpHandler, HelpTopic helpTopic) {
    mHelpHandler = helpHandler;
    mHelpTopic = helpTopic;
  }

  @Override
  public void handleHelp(HelpTopic helpTopic) {
    if (hasHelp(helpTopic)) {
      System.out.println(TAG + "_Show editor button help!!!");
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
