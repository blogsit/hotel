package com.blog.blogsit.model.wechat.message;

/**
 * 微信的消息实体,公共的抽象类
 * 
 * @author hua.chen
 * 
 */
public abstract class AbstractMessage {

    protected String toUserName = "";
    protected String fromUserName = "";
    protected long createTime = 0;
    protected MsgType msgType;
    protected MsgMode msgMode;
    protected String msgTypeText = "";
    // 完整的消息原始信息
    protected String wholeContent = "";

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    public MsgMode getMsgMode() {
        return msgMode;
    }

    public void setMsgMode(MsgMode msgMode) {
        this.msgMode = msgMode;
    }

    public String getMsgTypeText() {
        return msgTypeText;
    }

    public void setMsgTypeText(String msgTypeText) {
        this.msgTypeText = msgTypeText;
    }

    public String getWholeContent() {
        return wholeContent;
    }

    public void setWholeContent(String wholeContent) {
        this.wholeContent = wholeContent;
    }

    @Override
    public String toString() {
        return "AMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
                + ", msgMode=" + msgMode + ", msgTypeText=" + msgTypeText + ",msgType=" + msgType + "]";
    }


}
