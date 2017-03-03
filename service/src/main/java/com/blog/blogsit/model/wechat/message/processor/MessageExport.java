package com.blog.blogsit.model.wechat.message.processor;


import com.blog.blogsit.model.wechat.message.AbstractMessage;

/**
 * 消息输出接口,用于消息的过滤处理
 * 
 * @author hua.chen
 * 
 */
public interface MessageExport {

    /**
     * 获取输出消息
     * 
     * @return
     */
    public AbstractMessage getExportMessage();

    /**
     * 设置输出消息
     * 
     * @param exportMessage
     */
    public void setExportMessage(AbstractMessage exportMessage);

}
