package com.blueflybee.designpatternstudy.decorator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityDecoratorBinding;
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

public class DecoratorActivity extends AppCompatActivity {

  private ActivityDecoratorBinding mBinding;
  private static final String FILE_PATH = "/home/shaojun/桌面/logcat/log.txt";
  private static final String STR_CONTENT = "装饰模式（decorator）";
  private String mResult;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_decorator);

    initData();

    initView();

  }

  private void initData() {
  }

  private void initView() {
    mBinding.btnWrite.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        DataStream stream = new FileDataStream(FILE_PATH);
        DataStream gzipStream = new GZIPCoder(new Base64Coder(new GZIPCoder(new Base64Coder(new Base64Coder(stream)))));
        mResult = gzipStream.write(getText());
        mBinding.tvResult.setText(mResult);
      }
    });

    mBinding.btnRead.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        DataStream stream = new FileDataStream(FILE_PATH);
        Base64Coder base64Coder = new Base64Coder(new Base64Coder(new GZIPCoder(new Base64Coder(new GZIPCoder(stream)))));
        String read = base64Coder.read(mResult);
        mBinding.tvResult.setText(read);
      }
    });

  }

  @NonNull
  private String getText() {
    return mBinding.etOriginalText.getText().toString().trim();
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
