package com.blueflybee.designpatternstudy.abstractfactory;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.composite.CarEquipment;
import com.blueflybee.designpatternstudy.databinding.ActivityAbsFactoryBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityProxyBinding;
import com.blueflybee.designpatternstudy.proxy.Graphic;
import com.blueflybee.designpatternstudy.proxy.ImageProxy;

public class AbstractFactoryActivity extends AppCompatActivity {

  private ActivityAbsFactoryBinding mBinding;

  private CarMaker mCarMaker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_abs_factory);

    initData();

    initView();

  }

  private void initData() {
    mCarMaker = new CarMaker();
  }

  private void initView() {
    getSupportActionBar().setTitle("抽象工厂模式（Abstract factory 对象创建）");
    mBinding.btnCommon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CarEquipment car = mCarMaker.make(CarFactory.instance());
        mBinding.tvResult.setText(car.info());
      }
    });

    mBinding.btnUpgrade.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CarEquipment car = mCarMaker.make(UpgradeCarFactory.instance());
        mBinding.tvResult.setText(car.info());
      }
    });

    mBinding.btnDeluxe.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CarEquipment car = mCarMaker.make(DeluxeCarFactory.instance());
        mBinding.tvResult.setText(car.info());
      }
    });

  }

}
