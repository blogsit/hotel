package com.blog.blogsit.builder;

import java.util.List;

import com.blog.blogsit.model.wechat.message.AbstractMessage;
import com.blog.blogsit.model.wechat.message.ImageTextMessage;
import com.blog.blogsit.model.wechat.message.DefaultEventMessage;
import com.blog.blogsit.model.wechat.message.DefaultGeneralMessage;
import com.blog.blogsit.model.wechat.message.EventType;
import com.blog.blogsit.model.wechat.message.ImageTextItem;
import com.blog.blogsit.model.wechat.message.MsgMode;
import com.blog.blogsit.model.wechat.message.MsgType;
import com.blog.blogsit.model.wechat.message.TextMessage;

/**
 * 
 * 功能描述：<br>
 * 消息构建器
 * 
 * @author hua.chen 2015年7月1日 下午4:11:41 <br>
 *         修改记录:
 */
public class MessageBuilder {

    public static DefaultGeneralMessage buildDefaultGeneralMessage(String fromUserName, String toUserName,
            String msgTypeText, String msgId, long createTime, String wholeContent) {
        DefaultGeneralMessage generalMessage = new DefaultGeneralMessage();
        MsgType msgType = MsgType.nameOf(msgTypeText);
        generalMessage.setCreateTime(createTime);
        generalMessage.setFromUserName(fromUserName);
        generalMessage.setToUserName(toUserName);
        generalMessage.setMsgId(msgId);
        generalMessage.setMsgTypeText(msgTypeText);
        generalMessage.setMsgMode(MsgMode.RECEIVE);
        generalMessage.setMsgType(msgType);
        generalMessage.setWholeContent(wholeContent);
        return generalMessage;
    }

    public static DefaultEventMessage buildDefaultEventMessage(DefaultGeneralMessage generalMessage, String event) {
        DefaultEventMessage eventMessage = new DefaultEventMessage();
        EventType eventType = EventType.nameOf(event);
        eventMessage.setCreateTime(generalMessage.getCreateTime());
        eventMessage.setEvent(event);
        eventMessage.setEventType(eventType);
        eventMessage.setFromUserName(generalMessage.getFromUserName());
        eventMessage.setMsgMode(generalMessage.getMsgMode());
        eventMessage.setMsgType(generalMessage.getMsgType());
        eventMessage.setMsgTypeText(generalMessage.getMsgTypeText());
        eventMessage.setToUserName(generalMessage.getToUserName());
        eventMessage.setWholeContent(generalMessage.getWholeContent());
        return eventMessage;
    }

    public static AbstractMessage buildSendMessage(AbstractMessage srcMessage, MsgType msgType, Object... args) {
        AbstractMessage message = null;
        switch (msgType) {
        case TEXT:
            TextMessage textMessage = new TextMessage();
            textMessage.setContent((String) args[0]);
            message = textMessage;
            break;

        case IMAGETEXT:
            ImageTextMessage imageTextMessage = new ImageTextMessage();
            imageTextMessage.setItems((List<ImageTextItem>) args[0]);
            imageTextMessage.setArticleCount((Integer) args[1]);
            message = imageTextMessage;
            break;

        default:
            break;
        }
        message.setCreateTime(System.currentTimeMillis());
        message.setMsgType(msgType);
        message.setFromUserName(srcMessage.getToUserName());
        message.setMsgMode(MsgMode.SEND);
        message.setToUserName(srcMessage.getFromUserName());
        return message;
    }

}
