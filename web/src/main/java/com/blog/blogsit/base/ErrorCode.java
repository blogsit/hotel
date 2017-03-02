package com.blog.blogsit.base;

/**
 * Created by hua.chen on 2016/11/7.
 */
public class ErrorCode {
    /**
     * 参数校验失败
     */
    public static final int PARAM_CHECK_ERROR = 10;
    /**
     * 业务执行异常
     */
    public static final int BIZ_ERROR = 20;
    /**
     * 系统内部异常
     */
    public static final int INTERNAL_SYSTEM_ERROR = 30;
    /**
     * 调用外部接口异常
     */
    public static final int EXTERNAL_API_ERROR = 40;
    /**
     * 未知异常
     */
    public static final int UNKNOWN_ERROR = 999;
}
