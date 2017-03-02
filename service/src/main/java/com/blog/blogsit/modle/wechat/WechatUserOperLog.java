package com.blog.blogsit.modle.wechat;

import java.util.Date;

/**
 * 
 * 功能描述：<br>
 * 微信用户操作日志
 * @author hua.chen 2015年7月2日 下午3:29:28 <br>
 * 修改记录:
 */
public class WechatUserOperLog {

    /**
     * 微信用户的标识，对特定公众号唯一
     */
    private String userOpenid;
    /**
     * 微信公众号
     */
    private String publicOpenid;
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 操作人员
     */
    private String operator;
    /**
     * 操作类型,1-关注,2-绑定,3-取消关注,4-解除绑定
     */
    private int operType;
    /**
     * 操作时间
     */
    private Date operTime;
    /**
     * 操作内容
     */
    private String content = "";

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public String getPublicOpenid() {
        return publicOpenid;
    }

    public void setPublicOpenid(String publicOpenid) {
        this.publicOpenid = publicOpenid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getOperType() {
        return operType;
    }

    public void setOperType(int operType) {
        this.operType = operType;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
