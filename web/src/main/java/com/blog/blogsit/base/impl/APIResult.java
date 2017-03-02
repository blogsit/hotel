package com.blog.blogsit.base.impl;

import com.blog.blogsit.base.Result;

/**
 * 
 * 功能描述：<br>
 * 返回参数格式
 * 
 * @author hua.chen 2015年6月29日 下午4:50:42 <br>
 *         修改记录:
 */
public class APIResult<T> implements Result {
    private final String ver = "1.0";
    private boolean ret;
    private String errmsg;
    private Object[] errargs;
    private int errcode;
    private T data;

    public APIResult() {
    }

    private APIResult(T t) {
        this.ret = true;
        this.data = t;
    }

    private APIResult(int errcode, String errmsg) {
        this.ret = false;
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    private APIResult(int errcode, String errmsg, Object[] errargs) {
        this.ret = false;
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.errargs = errargs;
    }

    public static <T> APIResult<T> buildSuccessResult() {
        return new APIResult<T>(null);
    }

    public static <T> APIResult<T> buildSuccessResult(T t) {
        return new APIResult<T>(t);
    }

    public static <T> APIResult<T> buildFailedResult(int errcode, String errmsg) {
        return new APIResult<T>(errcode, errmsg);
    }

    public static <T> APIResult<T> buildFailedResult(int errcode, String errmsg, Object[] errArgs) {
        return new APIResult<T>(errcode, errmsg, errArgs);
    }

    public static <T> APIResult<T> buildFailedResult(String errmsg) {
        return new APIResult<T>(-1, errmsg);
    }

    public String getVer() {
        return ver;
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object[] getErrargs() {
        return errargs;
    }

    public void setErrargs(Object[] errargs) {
        this.errargs = errargs;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
