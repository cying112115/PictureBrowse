package com.dahe.picturebrowse.mvp.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.dahe.picturebrowse.presenter.BasePresenter;
import com.dahe.picturebrowse.utils.BaseAppManager;
import com.dahe.picturebrowse.utils.CommonUtils;
import com.dahe.picturebrowse.utils.NetUtils;
import com.dahe.picturebrowse.view.BaseView;

import butterknife.ButterKnife;

/**
 * Created by cying on 2017/5/19.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected T mPresenter;

    /**
     * context
     */
    protected Context mContext = null;

    protected int statusBarColor = 0;
    protected View statusBarView = null;  //  TODO  应该是状态栏的  need
    private boolean mNowMode;   //  TODO  当前模式的标示  need

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        setContentView(getLayoutId());
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        //        ButterKnife.inject(this);
        setTranslucentStatus(isApplyStatusBarTranslucency());

        initInjector();
        NetUtils.isNetworkErrThenShowMsg(this);

        initViewsAndEvents();

        BaseAppManager.getInstance().addActivity(this);
        if (mPresenter != null) {
            mPresenter.onCreate();
        }
    }


    protected void transparent19and20() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * bind layout resource file
     *
     * @return id of layout resource
     */
    public abstract int getLayoutId();

    public abstract void initInjector();


    /**
     * init all views and add events
     */
    protected abstract void initViewsAndEvents();


    /**
     * is applyStatusBarTranslucency
     *
     * @return
     */
    protected abstract boolean isApplyStatusBarTranslucency();

    /**
     * startActivity
     *
     * @param clazz
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    /**
     * set status bar translucency
     * TODO  设置状态栏透明
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void finish() {
        super.finish();

    }


    @Override
    public void showErrorMsg(String msg) {
        CommonUtils.customToast(mContext, msg, CommonUtils.ERROR);
    }

    @Override
    public void showSuccessMsg(String msg) {
        CommonUtils.customToast(mContext, msg, CommonUtils.SUCCESS);
    }

    private MaterialDialog dialog;

    @Override
    public void showProgress() {
        if (dialog == null) {
            dialog = new MaterialDialog.Builder(this)
                    .content("数据加载中")
                    .progress(true, 0)
                    .build();
        }
        dialog.show();

    }

    @Override
    public void hideProgress() {
        if (dialog != null) {
            dialog.dismiss();
        }

    }

}
