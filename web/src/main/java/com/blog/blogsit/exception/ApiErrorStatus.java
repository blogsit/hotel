package com.blog.blogsit.exception;

/**
 * 
 * 功能描述：<br>
 * 异常定义
 * 
 * @author hua.chen 2015年7月1日 下午7:27:44 <br>
 *         修改记录:
 */
public enum ApiErrorStatus {

    requestParamError(1, "请求参数不合法"), //
    wechat_messageParseException(2, "微信接收消息解析异常");
    private final int code;

    private String desc;

    private ApiErrorStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public ApiErrorStatus desc(String desc) {
        this.desc = desc;
        return this;
    }

    public ServiceException newServiceException() {
        return new ServiceException(this.code, this.desc);
    }

    public ServiceException newServiceException(Object data) {
        return new ServiceException(this.code, this.desc, data);
    }
}
