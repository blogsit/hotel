package com.blog.blogsit.util;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.blog.blogsit.utils.JsonUtil;

public class TestModel {
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ss.S'Z'")
    private Date dataChange_LastTime;// 时间戳
    
    public Date getDataChange_LastTime() {
        return dataChange_LastTime;
    }

    public void setDataChange_LastTime(Date dataChange_LastTime) {
        this.dataChange_LastTime = dataChange_LastTime;
    }

    public static void main(String[] args) {
        TestModel TestModel = JsonUtil.fromJSONString("{\"dataChange_LastTime\":\"2016-03-11T12:05:35.273\"}", TestModel.class);
        System.out.println(JsonUtil.toJSONString(TestModel));
    }
}
