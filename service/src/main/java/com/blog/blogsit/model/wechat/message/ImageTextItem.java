package com.blog.blogsit.model.wechat.message;

/**
 * @author hua.chen 2015年7月1日 上午11:06:28 <br>
 */
public class ImageTextItem {
    private String title;
    private String description;
    private String picUrl;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageTextItem{" + "title='" + title + '\'' + ", description='" + description + '\'' + ", picUrl='"
                + picUrl + '\'' + ", url='" + url + '\'' + '}';
    }
}
