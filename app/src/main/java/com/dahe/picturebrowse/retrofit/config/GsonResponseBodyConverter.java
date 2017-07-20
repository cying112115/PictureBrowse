package com.dahe.picturebrowse.retrofit.config;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Administrator on 2017/4/28.
 */

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final int TOKEN_FAIL=0;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        return null;
    }

    //    @Override public T convert(ResponseBody value) throws IOException {
//        String response=value.string();
//        BaseGenericResult result = gson.fromJson(response, BaseGenericResult.class);
//        if(result.getResult()==TOKEN_FAIL){
//            //重新登录
//            AppApplication.getInstance().loginAgain();
//            return null;
//        }else if(result.getResult() == 2){
//            AppApplication.getInstance().offlineTip();
//            return null;
//        }
//        if(result.getResult()!=200){
//            value.close();
//            ApiError error = new ApiError(result.getMsg(),result.getResult());
//            throw  error;
//        }
//        MediaType mediaType = value.contentType();
//        Charset charset = mediaType != null ? mediaType.charset(UTF_8) : UTF_8;
//        ByteArrayInputStream bis = new ByteArrayInputStream(response.getBytes());
//        InputStreamReader reader = new InputStreamReader(bis,charset);
//        JsonReader jsonReader = new JsonReader(reader);
//        try {
//            return adapter.read(jsonReader);
//        }finally {
//            value.close();
//        }
//    }
}