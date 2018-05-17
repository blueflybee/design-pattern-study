package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.interpreter.AndExp;
import com.blueflybee.designpatternstudy.interpreter.BooleanContext;
import com.blueflybee.designpatternstudy.interpreter.BooleanExp;
import com.blueflybee.designpatternstudy.interpreter.ConstantExp;
import com.blueflybee.designpatternstudy.interpreter.NotExp;
import com.blueflybee.designpatternstudy.interpreter.OrExp;
import com.blueflybee.designpatternstudy.interpreter.VariableExp;

import org.junit.Test;
import org.mockito.internal.matchers.And;
import org.mockito.internal.matchers.Or;

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
    boolean result = x.evaluate(context);
    assertEquals(true, result);
  }

  @Test
  public void evaluateConstantExp_Correct() {
    ConstantExp constantExp = new ConstantExp(true);
    BooleanContext context = new BooleanContext();
    boolean result = constantExp.evaluate(context);

    assertEquals(true, result);
  }

  @Test
  public void evaluateAndExp_Correct() {
    VariableExp exp1 = new VariableExp("x");
    BooleanContext context = new BooleanContext();
    context.assign(exp1, new ConstantExp(true));

    ConstantExp exp2 = new ConstantExp(false);

    AndExp andExp = new AndExp(exp1, exp2);
    boolean result = andExp.evaluate(context);

    assertEquals(false, result);
  }

  @Test
  public void evaluateOrExp_Correct() {
    VariableExp exp1 = new VariableExp("x");
    BooleanContext context = new BooleanContext();
    context.assign(exp1, new ConstantExp(true));

    ConstantExp exp2 = new ConstantExp(false);

    OrExp orExp = new OrExp(exp1, exp2);
    boolean result = orExp.evaluate(context);

    assertEquals(true, result);
  }

  @Test
  public void evaluateNotExp_Correct() {
    VariableExp exp1 = new VariableExp("x");
    BooleanContext context = new BooleanContext();
    context.assign(exp1, new ConstantExp(false));

    NotExp notExp = new NotExp(exp1);
    boolean result = notExp.evaluate(context);

    assertEquals(true, result);
  }
//  orExp = OrExp{mExp1=AndExp{mExp1=ConstantExp{mConstant=true}, mExp2=VariableExp{mName='x'}}, mExp2=AndExp{mExp1=VariableExp{mName='y'}, mExp2=NotExp{mExp=VariableExp{mName='x'}}}}
//
  @Test
  public void evaluateCompositeExp_Correct() {
    VariableExp x = new VariableExp("x");
    VariableExp y = new VariableExp("y");
    AndExp exp1 = new AndExp(new ConstantExp(true), x);
    AndExp exp2 = new AndExp(y, new NotExp(x));

    OrExp orExp = new OrExp(exp1, exp2);
    BooleanContext context = new BooleanContext();

    context.assign(x, new ConstantExp(false));
    context.assign(y, new ConstantExp(true));

    System.out.println("orExp = " + orExp);
    boolean result = orExp.evaluate(context);
//    System.out.println("result = " + result);
    assertEquals(true, result);
  }
}
