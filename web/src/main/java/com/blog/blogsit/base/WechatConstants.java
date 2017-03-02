package com.blog.blogsit.base;

import com.blog.blogsit.util.PropertyUtil;
import com.blog.blogsit.util.PropertyUtil;
import com.blog.blogsit.util.PropertyUtil;

/**
 * 
 * 功能描述：<br>
 * 微信工程常量配置类
 * 
 * @author hua.chen 2015年7月1日 下午7:56:31 <br>
 *         修改记录:
 */

public class WechatConstants {

    /** 视科技 服务号 OpenId **/
    public static final String HOTEL_ASSISTANT_SERVICENO = PropertyUtil.getProperty("wechat.hotel.assistant.serviceNo",
            "gh_fe67a2cec6e9");
    /** 微信 获取token **/
    public static final String WECHAT_GET_ACCESS_TOKEN_URL = PropertyUtil.getProperty("wechat.getAccessTokenUrl");
    /** 微信 获取用户 **/
    public static final String WECHAT_USER_INFO_URL = PropertyUtil.getProperty("wechat.getUserInfoUrl");
    /** 微信 oauth2 授权地址 **/
    public static final String WECHAT_AUTHORIZE_URL = PropertyUtil.getProperty("wechat.authorizeUrl");
    /** 微信 oauth2 accessToken获取地址 **/
    public static final String WECHAT_ACCESSTOKEN_URL = PropertyUtil.getProperty("wechat.authAccessTokenUrl");
    /** 微信模板消息发送接口地址 **/
    public static final String WECHAT_TMPLMSG_SEND_URL = PropertyUtil.getProperty("wechat.tmplmsg.sendUrl");
    /** 发送客服消息接口地址 **/
    public static final String WECHAT_SEND_CUSTOM_MSG_URL = PropertyUtil.getProperty("wechat.customMsg.sendUrl");
}
