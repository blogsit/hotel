package com.blog.blogsit.model.wechat.message;

/**
 * 
 * 功能描述：<br>
 * 文本类型消息
 * 
 * @author hua.chen 2015年7月1日 上午10:52:18 <br>
 *         修改记录:
 */

public class TextMessage extends AbstractGeneralMessage {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMessage [content=" + content + ", " + super.toString() + "]";
    }

}
