package com.blog.blogsit.exception;


public class ServiceException extends BusinessException {
    private static final long serialVersionUID = 5712698810604255702L;

    final int code;

    final Object data;


    public ServiceException(String message) {
        super(message);
        this.code = 99;
        this.data = null;
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
        this.data = null;
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.data = null;
    }

    public ServiceException(int code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }
}
