package com.blog.blogsit.model;
/**
 * 
 * 功能描述：<br>
 * @author hua.chen 2015年7月2日 下午11:49:51 <br>
 * 修改记录:
 */
public enum WechatUserSubscribeStatus {

    SUBSCRIBE(1, "关注状态"), //
    UNSUBSCRIBE(2, "非关注状态"); //

    private int code;

    private String desc;

    WechatUserSubscribeStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
