package com.blueflybee.designpatternstudy.visitor;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityTemplateMethodBinding;
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

public class VisitorActivity extends AppCompatActivity {

  private ActivityVisitorBinding mBinding;
  private Equipment mPc;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_visitor);

    initData();

    initView();

  }

  private void initData() {
    mPc = createPC();
  }

  private void initView() {
    mBinding.btnPrice.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        PriceVisitor priceVisitor = new PriceVisitor();
        mPc.accept(priceVisitor);
        mBinding.tvResult.setText(String.valueOf(priceVisitor.getTotalPrice()));
      }
    });

    mBinding.btnPrint.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        PrintVisitor printVisitor = new PrintVisitor();
        mPc.accept(printVisitor);
        mBinding.tvResult.setText(printVisitor.print());
      }
    });

  }

  private Equipment createPC() {
    Equipment chassis = new EquipmentComposite();
    chassis.setName("机箱");
    Equipment mainBoard = new MainBoard();
    mainBoard.setName("主板");
    mainBoard.setPrice(1000);
    Equipment power = new Power();
    power.setName("电源");
    power.setPrice(500);
    chassis.add(mainBoard);
    chassis.add(power);

    Equipment floppyDisk = new FloppyDisk();
    floppyDisk.setName("软盘");
    floppyDisk.setPrice(200);
    Equipment card = new Card();
    card.setName("显卡");
    card.setPrice(200);
    Equipment bus = new Bus();
    bus.setName("总线");
    bus.setPrice(800);

    Equipment pc = new EquipmentComposite();
    pc.setName("总计");
    pc.add(chassis);
    pc.add(floppyDisk);
    pc.add(card);
    pc.add(bus);
    return pc;
  }

}
