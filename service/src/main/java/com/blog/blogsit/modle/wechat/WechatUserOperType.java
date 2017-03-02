package com.blog.blogsit.modle.wechat;

/**
 * 
 * 功能描述：<br>
 * 用户操作类型
 * 
 * @author hua.chen 2015年7月2日 下午3:29:35 <br>
 *         修改记录:
 */
public enum WechatUserOperType {

    SUBSCRIBE(1, "关注"), //
    BIND(2, "绑定"), //
    UNSUBSCRIBE(3, "取消关注"), //
    UNBIND(4, "解除绑定"); //

    private int code;

    private String desc;

    WechatUserOperType(int code, String desc) {
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
