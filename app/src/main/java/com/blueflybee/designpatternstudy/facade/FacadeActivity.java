package com.blueflybee.designpatternstudy.facade;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityFacadeBinding;

public class FacadeActivity extends AppCompatActivity {

  private ActivityFacadeBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_facade);

    initData();

    initView();

  }

  private void initData() {
  }

  private void initView() {
    mBinding.btnCompile.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new CompilerFacade().compile();
        mBinding.tvResult.setText("CompilerFacade compile !!!!!!");
      }
    });

  }

}
