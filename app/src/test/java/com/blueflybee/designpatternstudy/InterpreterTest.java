package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.interpreter.AndExp;
import com.blueflybee.designpatternstudy.interpreter.BooleanContext;
import com.blueflybee.designpatternstudy.interpreter.BooleanExp;
import com.blueflybee.designpatternstudy.interpreter.ConstantExp;
import com.blueflybee.designpatternstudy.interpreter.NotExp;
import com.blueflybee.designpatternstudy.interpreter.OrExp;
import com.blueflybee.designpatternstudy.interpreter.VariableExp;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   : Test chain of responsibility design pattern
 *     version: 1.0
 * </pre>
 */
public class InterpreterTest {

  @Test
  public void variableExp_copy_equals() {
    BooleanExp x = new VariableExp("x");
    BooleanExp xCopy = x.copy();
    assertEquals(x, xCopy);
  }

  @Test
  public void constantExp_copy_equals() {
    BooleanExp cTrue = new ConstantExp(true);
    BooleanExp cTrueCopy = cTrue.copy();
    assertEquals(cTrue, cTrueCopy);
  }

  @Test
  public void andExp_copy_equals() {
    BooleanExp x = new VariableExp("x");
    BooleanExp y = new VariableExp("y");
    BooleanExp andExp = new AndExp(x, y);
    BooleanExp andExpCopy = andExp.copy();
    assertEquals(andExp, andExpCopy);
  }

  @Test
  public void orExp_copy_equals() {
    BooleanExp x = new VariableExp("x");
    BooleanExp y = new VariableExp("y");
    BooleanExp orExp = new OrExp(x, y);
    BooleanExp orExpCopy = orExp.copy();
    assertEquals(orExp, orExpCopy);
  }

  @Test
  public void notExp_copy_equals() {
    BooleanExp x = new VariableExp("x");
    BooleanExp notExp = new NotExp(x);
    BooleanExp notExpCopy = notExp.copy();
    assertEquals(notExp, notExpCopy);
  }

  @Test
  public void variableExp_evaluateCorrect() {
    VariableExp x = new VariableExp("x");
    BooleanContext context = new BooleanContext();
    ConstantExp cTrue = new ConstantExp(true);
    context.assign(x, cTrue);
    BooleanExp result = x.evaluate(context);
    assertEquals(cTrue, result);
  }
}
