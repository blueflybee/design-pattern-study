package com.blueflybee.designpatternstudy.mediator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;

public class MediatorActivity extends AppCompatActivity implements TestViewMediator.TestMediatorCallBack {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    new TestViewMediator(this).onCreate();
  }

  @Override
  public void onConfirmBtnClick(View v) {
    System.out.println("v = " + v);
  }

  @Override
  public int getLayoutId() {
    return R.layout.activity_mediator;
  }


}
