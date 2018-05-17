package com.blueflybee.designpatternstudy.interpreter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityInterpreterBinding;

public class InterpreterActivity extends AppCompatActivity {

  private ActivityInterpreterBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_interpreter);

    initData();

    initView();

  }

  private void initData() {
  }

  private void initView() {
    mBinding.btnEvaluate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
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
        mBinding.tvResult.setText(orExp.toString() + " = " + result);
      }
    });



  }
}
