package com.blog.blogsit.modle.wechat;

/**
 * 
 * 功能描述：<br>
 * 微信服务号实体
 * @author hua.chen 2015年7月1日 下午7:50:23 <br>
 * 修改记录:
 */
public class WechatServiceNo {

    /** 服务号原始ID **/
    private String openId;
    
    /** 微信号 **/
    private String wechatNo;

    /** token码 **/
    private String token;

    /** 开发者凭据 公众号的唯一标识 **/
    private String appId;

    /** 开发者凭据 公众号的appsecret **/
    private String appSecret;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public String toString() {
        return "WechatServiceNo [openId=" + openId + ", wechatNo=" + wechatNo + ", token=" + token
                + ", appId=" + appId + ", appSecret=" + appSecret + "]";
    }

}
