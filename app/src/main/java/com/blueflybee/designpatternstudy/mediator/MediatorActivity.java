package com.blueflybee.designpatternstudy.mediator;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityMediatorBinding;

public class MediatorActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivityMediatorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mediator);
    ViewMediator viewMediator = new ViewMediator(binding);

  }


}
