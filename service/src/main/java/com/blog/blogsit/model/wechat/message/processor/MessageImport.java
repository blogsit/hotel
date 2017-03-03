package com.blog.blogsit.model.wechat.message.processor;


import com.blog.blogsit.model.wechat.message.AbstractMessage;
import com.blog.blogsit.model.wechat.message.EventType;
import com.blog.blogsit.model.wechat.message.MsgType;

/**
 * 消息输入接口,用于消息的过滤处理
 * 
 * @author hua.chen
 * 
 */
public interface MessageImport {

    /**
     * 获取输入消息
     * 
     * @return
     */
    public AbstractMessage getImportMessage();

    public MsgType getMessageType();

    public EventType getMsgEventType();
}
