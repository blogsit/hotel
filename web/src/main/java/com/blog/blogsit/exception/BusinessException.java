package com.blog.blogsit.exception;

/**
 * 业务异常。业务必须捕捉处理的异常，它属于业务的一部分。
 */
public class BusinessException extends Exception {
    private static final long serialVersionUID = -2411288278707048387L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
