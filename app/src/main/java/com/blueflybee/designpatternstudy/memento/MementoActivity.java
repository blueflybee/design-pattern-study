package com.blueflybee.designpatternstudy.memento;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.command.Command;
import com.blueflybee.designpatternstudy.command.CommandApplication;
import com.blueflybee.designpatternstudy.command.Document;
import com.blueflybee.designpatternstudy.command.MacroCommand;
import com.blueflybee.designpatternstudy.command.OpenCommand;
import com.blueflybee.designpatternstudy.command.PasteCommand;
import com.blueflybee.designpatternstudy.databinding.ActivityCommandBinding;
import com.blueflybee.designpatternstudy.databinding.ActivityMementoBinding;
import com.blueflybee.designpatternstudy.memento.multimemento.Caretaker;
import com.blueflybee.designpatternstudy.memento.multimemento.Originator;

public class MementoActivity extends AppCompatActivity {

  private ActivityMementoBinding mBinding;
  private static final String STATE_1 = "state_0";
  private static final String STATE_2 = "state_1";
  private static final String STATE_3 = "state_2";
  private static final String STATE_4 = "state_3";
  private static final String STATE_5 = "state_4";
  private static final String STATE_6 = "state_5";
  private Caretaker mCaretaker;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_memento);

    initData();

    initView();

  }

  private void initData() {
    mCaretaker = new Caretaker(Originator.instance());
  }

  private void initView() {
    mBinding.btnSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //Originator set state and create memento

        Originator originator = Originator.instance();

        originator.setState(STATE_1);
        mCaretaker.createMemento();

        originator.setState(STATE_2);
        mCaretaker.createMemento();

        originator.setState(STATE_3);
        mCaretaker.createMemento();

        originator.setState(STATE_4);
        mCaretaker.createMemento();

        originator.setState(STATE_5);
        mCaretaker.createMemento();

        originator.setState(STATE_6);
        mCaretaker.createMemento();

        System.out.println("caretaker = " + mCaretaker);

      }
    });

    mBinding.btnRestore0.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Originator originator = Originator.instance();

        mCaretaker.setMemento(0);
        mBinding.tvData.setText("restore to state 0 : originator = " + originator);
      }
    });

    mBinding.btnRestore1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Originator originator = Originator.instance();

        mCaretaker.setMemento(1);
        mBinding.tvData.setText("restore to state 1 : originator = " + originator);
      }
    });

    mBinding.btnRestore2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Originator originator = Originator.instance();

        mCaretaker.setMemento(2);
        mBinding.tvData.setText("restore to state 2 : originator = " + originator);
      }
    });

    mBinding.btnRestore3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Originator originator = Originator.instance();

        mCaretaker.setMemento(3);
        mBinding.tvData.setText("restore to state 3 : originator = " + originator);
      }
    });

  }
}
