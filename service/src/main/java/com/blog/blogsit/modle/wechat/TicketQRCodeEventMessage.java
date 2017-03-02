package com.blog.blogsit.modle.wechat;

import com.blog.blogsit.modle.wechat.message.AbstractEventMessage;

/**
 * 扫描带参数二维码事件
 * 
 * @author zuju.li
 * 
 */
public class TicketQRCodeEventMessage extends AbstractEventMessage {

    private String eventKey;
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Message [eventKey=" + eventKey + ", ticket=" + ticket + ", " + super.toString() + "]";
    }



}
