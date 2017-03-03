package com.blog.blogsit.model.wechat.message.processor;


import com.blog.blogsit.model.wechat.message.AbstractMessage;
import com.blog.blogsit.model.wechat.message.AbstractEventMessage;
import com.blog.blogsit.model.wechat.message.EventType;
import com.blog.blogsit.model.wechat.message.MsgType;

public class DefaultMessageImport implements MessageImport {

    private AbstractMessage importMessage;
    private EventType eventType;

    public DefaultMessageImport(AbstractMessage importMessage) {
        this.importMessage = importMessage;
        if (this.importMessage instanceof AbstractEventMessage) {
            this.eventType = ((AbstractEventMessage) importMessage).getEventType();
        }
    }

    @Override
    public AbstractMessage getImportMessage() {
        return importMessage;
    }

    @Override
    public MsgType getMessageType() {
        return this.importMessage.getMsgType();
    }

    @Override
    public EventType getMsgEventType() {
        return eventType;
    }

    public void setImportMessage(AbstractMessage importMessage) {
        this.importMessage = importMessage;
    }


}
