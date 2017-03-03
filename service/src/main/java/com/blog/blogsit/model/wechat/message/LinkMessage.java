package com.blog.blogsit.model.wechat.message;

/**
 * 
 * 功能描述：<br>
 * 
 * @author hua.chen 2015年7月1日 下午7:27:18 <br>
 *         修改记录:
 */
public class LinkMessage extends AbstractGeneralMessage {

    private String title;
    private String description;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LinkMessage [title=" + title + ", description=" + description + ", url=" + url + ", "
                + super.toString() + "]";
    }

}
