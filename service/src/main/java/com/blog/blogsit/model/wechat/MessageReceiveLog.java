package com.blog.blogsit.model.wechat;


import com.blog.blogsit.model.wechat.message.AbstractMessage;

public class MessageReceiveLog extends AbstractMessage {

    private String event = "";
    private String msgId = "";

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

}
