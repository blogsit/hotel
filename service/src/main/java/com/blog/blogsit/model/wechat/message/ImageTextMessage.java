package com.blog.blogsit.model.wechat.message;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 
 * 功能描述：<br>
 * 图文消息类
 * @author hua.chen 2015年7月1日 上午11:06:17 <br>
 * 修改记录:
 */
public class ImageTextMessage extends AbstractGeneralMessage{

    private int articleCount = 1;
    private List<ImageTextItem> items = Lists.newArrayList();
    private int funcFlag = 0;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<ImageTextItem> getItems() {
        return items;
    }

    public void setItems(List<ImageTextItem> items) {
        this.items = items;
    }

    public int getFuncFlag() {
        return funcFlag;
    }

    public void setFuncFlag(int funcFlag) {
        this.funcFlag = funcFlag;
    }
}
