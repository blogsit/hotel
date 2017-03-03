package com.blog.blogsit.model.wechat.message;
/**
 * 
 * 功能描述：<br>
 * 消息类型
 * @author hua.chen 2015年7月1日 上午10:52:18 <br>
 * 修改记录:
 */

public enum MsgType {

    TEXT("text"), //
    LINK("link"), //
    IMAGE("image"), //
    EVENT("event"), //
    IMAGETEXT("imageText"); //

    public static MsgType nameOf(String name) {
        MsgType[] items = MsgType.values();
        for (MsgType msgType : items) {
            if (msgType.getName().equalsIgnoreCase(name)) {
                return msgType;
            }
        }
        return null;
    }

    private final String name;

    public String getName() {
        return name;
    }

    private MsgType(String name) {
        this.name = name;
    }

}
