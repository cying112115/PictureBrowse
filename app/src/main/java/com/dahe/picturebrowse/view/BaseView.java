package com.dahe.picturebrowse.view;

/**
 * Created by xk on 2017/4/13.
 */

public interface BaseView {

    void showProgress();

    void hideProgress();

    void showErrorMsg(String msg);
    void showSuccessMsg(String msg);
}
