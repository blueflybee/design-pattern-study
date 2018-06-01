package com.blueflybee.designpatternstudy.adapter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityAdapterBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityVisitorBinding;
import com.blueflybee.designpatternstudy.visitor.Bus;
import com.blueflybee.designpatternstudy.visitor.Card;
import com.blueflybee.designpatternstudy.visitor.Equipment;
import com.blueflybee.designpatternstudy.visitor.EquipmentComposite;
import com.blueflybee.designpatternstudy.visitor.FloppyDisk;
import com.blueflybee.designpatternstudy.visitor.MainBoard;
import com.blueflybee.designpatternstudy.visitor.Power;
import com.blueflybee.designpatternstudy.visitor.PriceVisitor;
import com.blueflybee.designpatternstudy.visitor.PrintVisitor;

public class AdapterActivity extends AppCompatActivity {

  private ActivityAdapterBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_adapter);

    initData();

    initView();

  }

  private void initData() {
  }

  private void initView() {
    mBinding.btnObjectAdapter.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new TextShape(mBinding.tvResult).setText("object adapter");
      }
    });

    mBinding.btnClassAdapter.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        IImageShape imageShape = new ImageShape();
        imageShape.setBackground();
        imageShape.drawContent();

      }
    });

  }

}
