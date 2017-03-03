package com.blog.blogsit.model.wechat.message;
/**
 * 
 * 功能描述：<br>
 * 
 * @author hua.chen 2015年7月1日 上午10:16:50 <br>
 * 修改记录:
 */
public abstract class AbstractEventMessage extends AbstractMessage {

    protected EventType eventType;
    protected String event;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "AEventMessage [event=" + event + ", " + super.toString() + "]";
    }

}
