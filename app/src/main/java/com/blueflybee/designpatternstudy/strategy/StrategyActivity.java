package com.blueflybee.designpatternstudy.strategy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityStateBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityStrategyBinding;
import com.blueflybee.designpatternstudy.observer.ClockTimer;
import com.blueflybee.designpatternstudy.state.TCPConnection;
import com.blueflybee.designpatternstudy.state.TCPState;

public class StrategyActivity extends AppCompatActivity {

  private ActivityStrategyBinding mBinding;
  private Strategy mStrategy;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_strategy);

    initData();

    initView();

  }

  private void initData() {

  }

  private void initView() {
    mBinding.rgStrategy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
          case R.id.rb_apple:
            mStrategy = AppleStrategy.instance();
            break;

          case R.id.rb_watermelon:
            mStrategy = WatermelonStrategy.instance();
            break;

          case R.id.rb_litchi:
            mStrategy = LitchiStrategy.instance();
            break;
        }
      }
    });

    mBinding.btnApply.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (mStrategy == null) {
          Toast.makeText(StrategyActivity.this, "请选择策略", Toast.LENGTH_SHORT).show();
          return;
        }
        mStrategy.evaluate(new StrategyContext());
      }
    });

  }
}
