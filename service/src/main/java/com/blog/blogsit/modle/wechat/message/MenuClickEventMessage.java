package com.blog.blogsit.modle.wechat.message;

/**
 * 
 * 功能描述：<br>
 * 自定义菜单点击事件
 * 
 * @author hua.chen 2015年7月1日 下午7:30:38 <br>
 *         修改记录:
 */
public class MenuClickEventMessage extends AbstractEventMessage {

    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public String toString() {
        return "ClickMessage [eventKey=" + eventKey + ", " + super.toString() + "]";
    }

}
