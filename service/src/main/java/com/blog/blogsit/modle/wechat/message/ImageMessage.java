package com.blog.blogsit.modle.wechat.message;

public class ImageMessage extends AbstractGeneralMessage {

    private String picUrl;
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "ImageMessage [picUrl=" + picUrl + ", mediaId=" + mediaId + ", " + super.toString() + "]";
    }



}
