package com.blueflybee.designpatternstudy.builder;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;

import com.blueflybee.designpatternstudy.composite.CarEquipment;
import com.blueflybee.designpatternstudy.databinding.ActivityBuilderBinding;

public class BuilderActivity extends AppCompatActivity {

  private ActivityBuilderBinding mBinding;

  private CarMaker mCarMaker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_builder);

    initData();

    initView();

  }

  private void initData() {
    mCarMaker = new CarMaker();
  }

  private void initView() {
    getSupportActionBar().setTitle("生成器模式（Builder 对象创建）");
    mBinding.btnCommon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CarEquipment car = mCarMaker.make(new CarBuilder());
        mBinding.tvResult.setText(car.info());
      }
    });

    mBinding.btnUpgrade.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CarEquipment car = mCarMaker.make(new UpgradeCarBuilder());
        mBinding.tvResult.setText(car.info());
      }
    });

    mBinding.btnDeluxe.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CarEquipment car = mCarMaker.make(new DeluxeCarBuilder());
        mBinding.tvResult.setText(car.info());
      }
    });

  }

}
