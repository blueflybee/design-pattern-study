package com.blueflybee.designpatternstudy.chainofresponsibility;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blueflybee.designpatternstudy.R;
import com.blueflybee.designpatternstudy.databinding.ActivityChainOfResponsibilityBinding;

import static com.blueflybee.designpatternstudy.chainofresponsibility.HelpTopic.HELP_TOPIC_APPLICATION;
import static com.blueflybee.designpatternstudy.chainofresponsibility.HelpTopic.HELP_TOPIC_BUTTON;
import static com.blueflybee.designpatternstudy.chainofresponsibility.HelpTopic.HELP_TOPIC_DIALOG;
import static com.blueflybee.designpatternstudy.chainofresponsibility.HelpTopic.HELP_TOPIC_WINDOW;

public class ChainOfResponsibilityActivity extends AppCompatActivity {

  private ActivityChainOfResponsibilityBinding mBinding;
  private HelpHandler mEditorButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_chain_of_responsibility);

    initData();

    initView();

  }

  private void initData() {
    HelpHandler editorApplication = new EditorApplication();
    HelpHandler editorWindow = new EditorWindow(editorApplication, HELP_TOPIC_WINDOW);
    HelpHandler editorDialog = new EditorDialog(editorWindow, HELP_TOPIC_DIALOG);
    mEditorButton = new EditorButton(editorDialog, HELP_TOPIC_BUTTON);
  }

  private void initView() {
    mBinding.btnButtonHelp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mEditorButton.handleHelp(HELP_TOPIC_BUTTON);
      }
    });

    mBinding.btnDialogHelp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mEditorButton.handleHelp(HELP_TOPIC_DIALOG);
      }
    });


    mBinding.btnWindowHelp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mEditorButton.handleHelp(HELP_TOPIC_WINDOW);
      }
    });


    mBinding.btnApplicationHelp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mEditorButton.handleHelp(HELP_TOPIC_APPLICATION);
      }
    });
  }
}
