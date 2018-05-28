package com.blueflybee.designpatternstudy.observer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityMementoBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityObserverBinding;
import com.blueflybee.designpatternstudy.memento.multimemento.Caretaker;
import com.blueflybee.designpatternstudy.memento.multimemento.Originator;
import com.blueflybee.designpatternstudy.observer.ClockTimer;
import com.blueflybee.designpatternstudy.observer.DigitalClock;

public class ObserverActivity extends AppCompatActivity {

  private ActivityObserverBinding mBinding;
  private ClockTimer mTimer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_observer);

    initData();

    initView();

  }

  private void initData() {
    mTimer = new ClockTimer();
    DigitalClock digitalClock = new DigitalClock(mTimer);
    digitalClock.setOnUpdateListener(new DigitalClock.OnUpdateListener() {
      @Override
      public void onUpdate(final String time) {
        runOnUiThread(new Runnable() {
          @Override
          public void run() {

            mBinding.tvTimer.setText(time);
          }
        });
      }
    });

  }

  private void initView() {
    mBinding.btnTick.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mTimer.tick();
      }
    });

    mBinding.btnStop.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mTimer.stop();
        mBinding.tvTimer.setText("timer stopped");
      }
    });


  }
}
