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

  public boolean lookup(String name)  {
    ConstantExp constantExp = mVariableExpMap.get(name);
    if (constantExp == null) {
      System.out.println("should assign value to the boolean variable " + name);
      return false;
    }
    return constantExp.value();
  }
}
