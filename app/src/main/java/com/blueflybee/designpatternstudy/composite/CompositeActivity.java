package com.blueflybee.designpatternstudy.composite;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityCompositeBinding;
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

public class CompositeActivity extends AppCompatActivity {

  private ActivityCompositeBinding mBinding;
  private CarEquipment mCar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_composite);

    initData();

    initView();

  }

  private void initData() {
    mCar = createCar();
  }

  private void initView() {
    mBinding.btnPrice.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mBinding.tvResult.setText(String.valueOf(mCar.getNetPrice()));
      }
    });
  }

  @NonNull
  private CarEquipment createCar() {
    CarEquipment car = new CarEquipmentComposite("car");
    CarEquipment tire1 = new Tire("tire1");
    CarEquipment tire2 = new Tire("tire2");
    CarEquipment tire3 = new Tire("tire3");
    CarEquipment tire4 = new Tire("tire4");
    tire1.setNetPrice(100);
    tire2.setNetPrice(100);
    tire3.setNetPrice(100);
    tire4.setNetPrice(100);
    car.add(tire1);
    car.add(tire2);
    car.add(tire3);
    car.add(tire4);

    CarEquipment carBody = new CarEquipmentComposite("carBody");
    CarEquipment doorFrame = new DoorFrame("door frame");
    doorFrame.setNetPrice(2000);
    CarEquipment hood = new Hood("hood");
    hood.setNetPrice(10000);
    CarEquipment moonRoof = new MoonRoof("moon roof");
    moonRoof.setNetPrice(500);
    carBody.add(doorFrame);
    carBody.add(hood);
    carBody.add(moonRoof);

    car.add(carBody);
    return car;
  }

}
