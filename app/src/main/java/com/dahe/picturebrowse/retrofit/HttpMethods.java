package com.dahe.picturebrowse.retrofit;

import com.dahe.picturebrowse.mvp.bean.BaseGenericResult;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cying on 2017/6/12.
 */

public class HttpMethods {

        public static final String BASE_URL = "https://api.douban.com/v2/movie/";

        private static final int DEFAULT_TIMEOUT = 5;

        private Retrofit retrofit;
        private RetrofitInterface service;

        //构造方法私有
        private HttpMethods() {
            //手动创建一个OkHttpClient并设置超时时间
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

            retrofit = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();

            service = retrofit.create(RetrofitInterface.class);
        }

        //在访问HttpMethods时创建单例
        private static class SingletonHolder{
            private static final HttpMethods INSTANCE = new HttpMethods();
        }

        //获取单例
        public static HttpMethods getInstance(){
            return SingletonHolder.INSTANCE;
        }

    /**
     *
     * @param subscriber
     * @param uuid
     */
        public void getTopMovie(Subscriber<BaseGenericResult> subscriber, String uuid){
            service.deleteMaterialByUuid(uuid)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
        }

}
