package com.blueflybee.designpatternstudy.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BooleanContext {


  private Map<String, ConstantExp> mVariableExpMap = new HashMap<>();

  public void assign(VariableExp variableExp, ConstantExp constant) {
    mVariableExpMap.put(variableExp.getName(), constant);
  }

  public ConstantExp lookup(String name) {
    return mVariableExpMap.get(name);
  }
}
