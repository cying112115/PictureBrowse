package com.dahe.picturebrowse.presenter;

import android.support.annotation.NonNull;

import com.dahe.picturebrowse.view.BaseView;


/**
 * Created by xk on 2017/4/13.
 */

public interface BasePresenter {

    void onCreate();

    void attachView(@NonNull BaseView view);

    void onDestroy();

}
