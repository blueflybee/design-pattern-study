package com.blueflybee.designpatternstudy.command;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityCommandBinding;

public class CommandActivity extends AppCompatActivity {

  private ActivityCommandBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_command);

    initData();

    initView();

  }

  private void initData() {
  }

  private void initView() {
    mBinding.btnOpen.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Command openCommand = new OpenCommand(new CommandApplication());
        openCommand.execute();
      }
    });

    mBinding.btnPaste.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        new PasteCommand(new Document()).execute();
      }
    });


    mBinding.btnMacro.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Command openCommand1 = new OpenCommand(new CommandApplication());
        Command openCommand2 = new OpenCommand(new CommandApplication());
        Command openCommand3 = new OpenCommand(new CommandApplication());
        Command pasteCommand1 = new PasteCommand(new Document());
        Command pasteCommand2 = new PasteCommand(new Document());
        Command pasteCommand3 = new PasteCommand(new Document());
        Command pasteCommand4 = new PasteCommand(new Document());

        MacroCommand macroCommand = new MacroCommand();
        macroCommand.add(openCommand1);
        macroCommand.add(openCommand2);
        macroCommand.add(openCommand3);

        macroCommand.add(pasteCommand1);
        macroCommand.add(pasteCommand2);
        macroCommand.add(pasteCommand3);
        macroCommand.add(pasteCommand4);

        macroCommand.execute();
      }
    });

  }
}
