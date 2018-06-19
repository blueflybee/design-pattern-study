package com.blueflybee.designpatternstudy.proxy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityFlyweightBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityProxyBinding;
import com.blueflybee.designpatternstudy.flyweight.Glyph;
import com.blueflybee.designpatternstudy.flyweight.GlyphFactory;

public class ProxyActivity extends AppCompatActivity {

  private ActivityProxyBinding mBinding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_proxy);

    initData();

    initView();

  }

  private void initData() {
  }

  private void initView() {
    mBinding.btnDraw.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Graphic image = new ImageProxy("fileName");
        image.draw();
      }
    });

    mBinding.btnHandleMouse.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Graphic image = new ImageProxy("fileName");
        image.handleMouse();
      }
    });

  }

}
