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
public class EditorApplication implements HelpHandler {
  private static final String TAG = EditorApplication.class.getSimpleName();

  @Override
  public void handleHelp(HelpTopic helpTopic) {
    System.out.println(TAG + "_Show editor application help!!!");
  }
}
