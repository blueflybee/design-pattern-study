package com.blueflybee.designpatternstudy.bridge;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.adapter.IImageShape;
import com.blueflybee.designpatternstudy.adapter.ImageShape;
import com.blueflybee.designpatternstudy.adapter.TextShape;
import com.blueflybee.designpatternstudy.databinding.ActivityAdapterBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityBridgeBinding;

import java.util.function.BiConsumer;

public class BridgeActivity extends AppCompatActivity {

  private ActivityBridgeBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bridge);

    initData();

    initView();

  }

  private void initData() {
  }

  private void initView() {
    mBinding.btnSmallOriginalCoffee.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new SmallCoffee(new Original()).makeCoffee();
      }
    });

    mBinding.btnSmallSugarCoffee.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new SmallCoffee(new Sugar()).makeCoffee();

      }
    });

    mBinding.btnBigOriginalCoffee.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new BigCoffee(new Original()).makeCoffee();
      }
    });

    mBinding.btnBigSugarCoffee.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new BigCoffee(new Sugar()).makeCoffee();
      }
    });

  }

}
