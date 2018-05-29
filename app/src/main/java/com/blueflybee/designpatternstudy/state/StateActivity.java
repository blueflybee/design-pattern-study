package com.blueflybee.designpatternstudy.state;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityObserverBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityStateBinding;
import com.blueflybee.designpatternstudy.observer.ClockTimer;
import com.blueflybee.designpatternstudy.observer.DigitalClock;

public class StateActivity extends AppCompatActivity {

  private ActivityStateBinding mBinding;
  private TCPConnection mConnection;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_state);

    initData();

    initView();

  }

  private void initData() {
    mConnection = new TCPConnection();
  }

  private void initView() {
    mBinding.btnPassiveOpen.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mConnection.passiveOpen();
        TCPState state = mConnection.getState();
        mBinding.tvState.setText(state.getClass().getSimpleName());
      }
    });

    mBinding.btnActiveOpen.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mConnection.activeOpen();
        TCPState state = mConnection.getState();
        mBinding.tvState.setText(state.getClass().getSimpleName());
      }
    });

    mBinding.btnClose.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mConnection.close();
        TCPState state = mConnection.getState();
        mBinding.tvState.setText(state.getClass().getSimpleName());
      }
    });

    mBinding.btnSend.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mConnection.send();
        TCPState state = mConnection.getState();
        mBinding.tvState.setText(state.getClass().getSimpleName());
      }
    });


  }
}
