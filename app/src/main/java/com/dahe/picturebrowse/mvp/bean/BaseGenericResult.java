package com.dahe.picturebrowse.mvp.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/24.
 */

public class BaseGenericResult<T> implements Serializable {
    private int result;
    private String msg;
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}