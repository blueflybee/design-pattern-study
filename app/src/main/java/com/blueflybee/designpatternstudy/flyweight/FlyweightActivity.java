package com.blueflybee.designpatternstudy.flyweight;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityFlyweightBinding;

public class FlyweightActivity extends AppCompatActivity {

  private ActivityFlyweightBinding mBinding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_flyweight);

    initData();

    initView();

  }

  private void initData() {
  }

  private void initView() {
    mBinding.btnZh.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Glyph column = GlyphFactory.load(getString(R.string.para_zh));
        mBinding.tvResult.setText(column.print());
      }
    });

    mBinding.btnEn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Glyph column = GlyphFactory.load(getString(R.string.para_en));
        mBinding.tvResult.setText(column.print());
      }
    });

  }

}
