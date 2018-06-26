package com.blueflybee.designpatternstudy.factorymethod;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.abstractfactory.CarFactory;
import com.blueflybee.designpatternstudy.abstractfactory.CarMaker;
import com.blueflybee.designpatternstudy.abstractfactory.DeluxeCarFactory;
import com.blueflybee.designpatternstudy.abstractfactory.UpgradeCarFactory;
import com.blueflybee.designpatternstudy.composite.CarEquipment;
import com.blueflybee.designpatternstudy.databinding.ActivityAbsFactoryBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityFactoryMethodBinding;

public class FactoryMethodActivity extends AppCompatActivity {

  private ActivityFactoryMethodBinding mBinding;

  private CarMaker mCarMaker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_factory_method);

    initData();

    initView();

  }

  private void initData() {
    mCarMaker = new CarMaker();
  }

  private void initView() {
    getSupportActionBar().setTitle("工厂方法模式（Factory method 对象创建）");
    mBinding.btnCommon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CarEquipment car = mCarMaker.make(CrossCountryCarFactory.instance());
        mBinding.tvResult.setText(car.info());
      }
    });

  }

}
