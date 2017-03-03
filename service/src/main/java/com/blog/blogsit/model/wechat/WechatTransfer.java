package com.blog.blogsit.model.wechat;

import java.io.Serializable;

/**
 * 
 * 功能描述：<br>
 * 微信请求回调接口模型
 * 
 * @author hua.chen 2015年6月30日 上午11:42:50 <br>
 *         修改记录:
 */
public class WechatTransfer implements Serializable {
    /**
    *
    */
    private static final long serialVersionUID = 1L;

    /**
     * 签名
     */
    private String signature = null;

    /**
     * 时间戳
     */
    private String timestamp = null;

    /**
     * 随机数
     */
    private String nonce = null;

    /**
     * 随机字符串
     */
    private String echostr = null;

    /**
     * POST请求BODY
     */
    private String postBody;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

}
