package com.blueflybee.designpatternstudy.templatemethod;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityStateBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityTemplateMethodBinding;
import com.blueflybee.designpatternstudy.state.TCPConnection;
import com.blueflybee.designpatternstudy.state.TCPState;

public class TemplateMethodActivity extends AppCompatActivity {

  private ActivityTemplateMethodBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_template_method);

    initData();

    initView();

  }

  private void initData() {
  }

  private void initView() {
    mBinding.btnTv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new TvDisplay().display();
      }
    });

    mBinding.btnPhone.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new PhoneDisplay().display();
      }
    });


  }
}
