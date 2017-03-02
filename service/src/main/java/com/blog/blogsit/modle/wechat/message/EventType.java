package com.blog.blogsit.modle.wechat.message;

/**
 * 
 * 功能描述：<br>
 * 微信消息事件类型
 * @author hua.chen 2015年7月1日 上午10:18:44 <br>
 * 修改记录:
 */
public enum EventType {

    SUBSCRIBE("subscribe"),//订阅
    UNSUBSCRIBE("unsubscribe"),//取消订阅
    SCAN("scan"),//如果用户已经关注公众号,扫描带参数二维码事件
    CLICK("click"),//自定义菜单事件
    LOCATION("location");// 上报地理位置事件
    
    public static EventType nameOf(String name) {
        EventType[] items = EventType.values();
        for (EventType eventType : items) {
            if (eventType.getName().equalsIgnoreCase(name)) {
                return eventType;
            }
        }
        return null;
    }
    
    private final String name;

    public String getName() {
        return name;
    }

    private EventType(String name) {
        this.name = name;
    }
    
}
