package com.dahe.picturebrowse.retrofit;

import android.content.Context;
import android.util.Log;

import com.dahe.picturebrowse.AppApplication;
import com.dahe.picturebrowse.constants.ApiConstants;
import com.dahe.picturebrowse.retrofit.config.CustomeGsonFactory;
import com.dahe.picturebrowse.retrofit.cookiesync.PersistentCookieStore;
import com.dahe.picturebrowse.utils.CommonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by xk on 2017/4/13.
 */

public class RetrofitManager {

    private static RetrofitManager mInstance;
    private RetrofitInterface service;
    private CookieHandler cookieHandler;
    private PersistentCookieStore persistentCookieStore;


    public static RetrofitManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null)
                    mInstance = new RetrofitManager(context);
            }
        }
        return mInstance;
    }

    public RetrofitInterface getService() {
        return service;
    }

    public RetrofitManager(final Context context) {
        persistentCookieStore = new PersistentCookieStore(context);
        cookieHandler = new CookieManager(persistentCookieStore, CookiePolicy.ACCEPT_ALL);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); // BODY  HEADERS

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(120 * 1000, TimeUnit.MILLISECONDS)
                .connectTimeout(120 * 1000, TimeUnit.MILLISECONDS)
                .cookieJar(new JavaNetCookieJar(cookieHandler)) //  TODO  JavaNetCookieJar  →  compile 'com.squareup.okhttp3:okhttp-urlconnection:3.2.0'
//                .addInterceptor(logging)
                .addInterceptor(new Interceptor() { // TODO 设置通用的 Headers
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
//                                .addHeader("token", AppApplication.getToken()) //   "MTUxMzYxOTcwMDM="
                                .addHeader("version", AppApplication.getInstance().getAppVersionName(context))
                                .addHeader("os", "android") //从缓存中获取
                                .addHeader("deviceID", CommonUtils.getDeviceId(context))
                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();
        Log.e("cn","getDeviceId:  "+CommonUtils.getDeviceId(context));
        Gson gson = new GsonBuilder().serializeNulls().create();


        //        version 版本号1.0
        //        os 苹果或安卓apple、android
        //        token 登陆时传给客户端的值
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.Urls.BaseUrl)
                .addConverterFactory(CustomeGsonFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();


        service = retrofit.create(RetrofitInterface.class);
    }

    public void clearCookie() {
        persistentCookieStore.removeAll();
    }



    //-------------------------------


//    /**
//     * 所有的联系人
//     * /mobile/user/allusers
//     * <p>
//     * type : post
//     */
//    public Observable<DepartmentResult> getContactAllResultObservable() {
//        return service.getAllContactData(0);
//    }
//
//    /**
//     * 线索取为选题
//     * /mobile/clue/totopic/{id}
//     * id	int	是	要取用为选题的线索 ID
//     * type : post
//     */
//    public Observable<BaseResult> getClueBeUsedTopicResultObservable(int id) {
//        return service.clue_Be_Used_Topic_Data(id);
//    }



}

























