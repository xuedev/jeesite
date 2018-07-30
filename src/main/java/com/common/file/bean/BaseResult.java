package com.common.file.bean;


import org.activiti.engine.impl.util.json.JSONObject;

/**
 * 统一返回结果类
 * Created by shuzheng on 2017/2/18.
 */
public class BaseResult<T> {

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 状态码：0成功，其他为失败
     */
    public int code;

    /**
     * 成功为success，其他为失败原因
     */
    public String msg;

    /**
     * 数据结果集
     */
    public T data;

    public BaseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = (T) new JSONObject();
    }
}
