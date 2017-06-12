package com.dahe.picturebrowse.retrofit.config;

/**
 * Created by Administrator on 2017/5/13.
 */

public class ApiError extends Error{

    private int code;

    public ApiError(String msg,int code){
        super(msg);
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
