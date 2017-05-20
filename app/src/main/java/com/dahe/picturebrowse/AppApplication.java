package com.dahe.picturebrowse;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.dahe.picturebrowse.utils.BaseAppManager;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xk on 2017/4/13.
 */

public class AppApplication extends MultiDexApplication {

    private static AppApplication instance;

    private static List<Activity> activityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    private void recordActivity() {

        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                activityList.add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                activityList.remove(activity);
            }
        });

    }

    public static PackageInfo getPackageInfo() {
        try {
            return instance.getPackageManager().getPackageInfo(instance.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取 AppApplication 实例
     *
     * @return
     */
    public static AppApplication getInstance() {
        return instance;
    }

    /**
     * 获取APK 版本号
     *
     * @param context
     * @return
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    public static void exitApp() {
        BaseAppManager.getInstance().clear();
        System.gc();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
