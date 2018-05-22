package com.blueflybee.designpatternstudy.mediator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityMediatorBinding;

public class MediatorActivity extends AppCompatActivity {

  private ActivityMediatorBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mediator);

    ViewMediator viewMediator = new ViewMediator(mBinding);
    viewMediator.setOnConfirmBtnClickListener(new ViewMediator.OnConfirmBtnClickListener() {
      @Override
      public void onClick(View v) {
        System.out.println("v = " + v);
      }
    });

  }


}
