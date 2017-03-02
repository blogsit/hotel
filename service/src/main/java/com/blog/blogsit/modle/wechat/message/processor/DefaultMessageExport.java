package com.blog.blogsit.modle.wechat.message.processor;


import com.blog.blogsit.modle.wechat.message.AbstractMessage;
import com.blog.blogsit.modle.wechat.message.AbstractMessage;
import com.blog.blogsit.modle.wechat.message.AbstractMessage;

public class DefaultMessageExport implements MessageExport {

    private AbstractMessage exportMessage;

    public DefaultMessageExport() {

    }

    @Override
    public AbstractMessage getExportMessage() {
        return exportMessage;
    }


    @Override
    public void setExportMessage(AbstractMessage exportMessage) {
        this.exportMessage = exportMessage;
    }

}
