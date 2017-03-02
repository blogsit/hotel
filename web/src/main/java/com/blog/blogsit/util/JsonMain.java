package com.blog.blogsit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class JsonMain {
    public static void main(String[] args) throws IOException {
        String json ="";
        JSONArray contacts =JSON.parseArray(json.trim());
        if(contacts!=null){
            for(int i = 0;i<contacts.size();i++) {
                JSONObject JSONObject =contacts.getJSONObject(i);
                StringBuffer content = new StringBuffer();
                if(JSONObject.getString("lastName")!=null){
                    content.append(JSONObject.getString("lastName"));
                }
                if(JSONObject.getString("firstName")!=null){
                    content.append(JSONObject.getString("firstName"));
                }
                JSONArray phones =JSONObject.getJSONArray("phones")==null?JSONObject.getJSONArray("emailAddresses"):JSONObject.getJSONArray("phones");
                String phone = phones==null?"blogsit@163.com":phones.getJSONObject(0).getString("field");
                System.out.println(StringUtils.isEmpty(phone)?"邮箱地址":phone);
            }           
        }
        System.out.println();
    }
    public static String FileInputStreamDemo(String path) throws IOException{
        File file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        FileInputStream fis=new FileInputStream(file);
        byte[] buf = new byte[1024];
        StringBuffer sb=new StringBuffer();
        while((fis.read(buf))!=-1){
            sb.append(new String(buf));    
            buf=new byte[1024];//重新生成，避免和上次读取的数据重复
        }
        return sb.toString();
    }
}
