package com.blueflybee.designpatternstudy.mediator;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.blueflybee.designpatternstudy.databinding.ActivityMediatorBinding;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ViewMediator {

  private OnConfirmBtnClickListener mOnConfirmBtnClickListener;

  ViewMediator(final ActivityMediatorBinding binding) {
    init(binding);
  }

  private void init(final ActivityMediatorBinding binding) {
    Context context = binding.getRoot().getContext();
    final String[] fonts = {
        "字体1",
        "字体2",
        "字体3",
        "字体4",
        "字体5",
        "字体6",
        "字体7",
        "字体8",
        "字体9",
        "字体10",
    };
    binding.list.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_single_choice, fonts));
    binding.list.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
    binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        binding.et1.setText(fonts[position]);
      }
    });

    binding.et1.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        for (int i = 0; i < fonts.length; i++) {
          if (!fonts[i].equalsIgnoreCase(s.toString())) continue;
          binding.list.setSelection(i);
          binding.list.setItemChecked(i, true);
          break;
        }

        binding.btnConfirm.setEnabled(!TextUtils.isEmpty(s.toString()));
      }
    });

    binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (mOnConfirmBtnClickListener != null) {
          mOnConfirmBtnClickListener.onClick(v);
        }

      }
    });
  }

  void setOnConfirmBtnClickListener(OnConfirmBtnClickListener onConfirmBtnClickListener) {
    mOnConfirmBtnClickListener = onConfirmBtnClickListener;
  }

  interface OnConfirmBtnClickListener{
    void onClick(View v);
  }

}
