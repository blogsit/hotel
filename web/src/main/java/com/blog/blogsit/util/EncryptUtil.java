package com.blog.blogsit.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * 加密处理类
 * @author hua.chen 2016年5月19日 上午10:34:29 <br>
 * 修改记录:
 */
public class EncryptUtil {
    
    /**
     * 
     * 功能描述：<br>
     * @param content
     * @return 
     * @author hua.chen 2016年5月19日 上午10:34:42 <br>
     * 修改记录:
     */
    public static String encode(String content) {
        return encrypt(content, null);
    }

    public static String encrypt(String strSrc,String encName) {
        MessageDigest md=null;
        String strDes=null;
        byte[] bt=strSrc.getBytes();
        
        
        try {
            if (encName==null||encName.equals("")) {
                encName="MD5";
            }
            md=MessageDigest.getInstance(encName);
            md.update(bt);
            strDes=bytes2Hex(md.digest());  
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    public static String bytes2Hex(byte[] buffer) {
        StringBuilder buf = new StringBuilder(buffer.length * 2);
        for (int i = 0; i < buffer.length; i++) {
            if (((int) buffer[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) buffer[i] & 0xff, 16));
        }
        return buf.toString();
    }

}
