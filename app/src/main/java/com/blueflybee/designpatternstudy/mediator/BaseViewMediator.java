package com.blueflybee.designpatternstudy.mediator;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class BaseViewMediator<B extends ViewDataBinding, M extends IMediate> {

  private final B mBinding;
  protected M mMediateAble;

  public BaseViewMediator(M mediateAble) {
    mBinding = DataBindingUtil.setContentView((Activity) mediateAble, mediateAble.getLayoutId());
    mMediateAble = mediateAble;
  }

  public final void onCreate() {
    onCreate(mBinding);
  }

  public final void onStart() {
    onStart(mBinding);
  }

  public final void onRestart() {
    onRestart(mBinding);
  }

  public final void onResume() {
    onResume(mBinding);
  }

  public final void onPause() {
    onPause(mBinding);
  }

  public final void onStop() {
    onStop(mBinding);
  }

  public final void onDestroy() {
    onDestroy(mBinding);
  }

  protected Context getContext() {
    return ((Activity) mMediateAble);
  }

  protected void onCreate(final B binding) {

  }

  protected void onStart(final B binding) {

  }

  protected void onRestart(final B binding) {

  }

  protected void onResume(final B binding) {

  }

  protected void onPause(final B binding) {

  }

  protected void onStop(final B binding) {

  }

  protected void onDestroy(final B binding) {

  }


}
