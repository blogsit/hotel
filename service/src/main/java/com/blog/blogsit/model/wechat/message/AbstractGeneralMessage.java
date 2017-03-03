package com.blog.blogsit.model.wechat.message;

/**
 * 
 * 功能描述：<br>
 * 微信接收普通消息的抽象实体类
 * @author hua.chen 2015年7月1日 上午10:19:17 <br>
 * 修改记录:
 */
public abstract class AbstractGeneralMessage extends AbstractMessage {

    protected String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "AGeneralMessage [msgId=" + msgId + ", " + super.toString() + "]";
    }

}
