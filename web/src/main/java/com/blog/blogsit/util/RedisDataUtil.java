package com.blog.blogsit.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;

public class RedisDataUtil {

    public static void main(String[] args) {
        String encrypted = "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABc3IAK2NvbS5xdW5hci5ob3RlbC5lYm9va2luZy5yYmFjLm1vZGVsLkVCSG90ZWz//////////wIADloAB2NoZWNrZWRaABFkaXJlY3RDb25uZWN0RmxhZ0oAB2hvdGVsSWRMAARjaXR5dAASTGphdmEvbGFuZy9TdHJpbmc7TAAIY2l0eUNvZGVxAH4AA0wAB2NvdW50cnlxAH4AA0wACWN1cnJlbnlWb3QALExjb20vcXVuYXIvaG90ZWwvZWJvb2tpbmcvcmJhYy92by9DdXJyZW55Vm87TAALaG90ZWxJbk5hbWVxAH4AA0wACWhvdGVsTmFtZXEAfgADTAAIaG90ZWxTZXFxAH4AA0wABWxldmVsdAA5TGNvbS9xdW5hci9ob3RlbC9lYm9va2luZy9yYmFjL21vZGVsL0VCSG90ZWwkU0hvdGVsTGV2ZWw7TAAIcHJvdmluY2VxAH4AA0wAA3FpZHEAfgADTAAKc3VwcGxpZXJJZHQAEExqYXZhL2xhbmcvTG9uZzt4cAEAAAAAAABMr8x0AAblrp3puKF0AAViYW9qaXQABuS4reWbvXNyACpjb20ucXVuYXIuaG90ZWwuZWJvb2tpbmcucmJhYy52by5DdXJyZW55Vm/2VS+04NiHqQIAA0wADGN1cnJlbmN5Q29kZXEAfgADTAAMY3VycmVuY3lEZXNjcQB+AANMAA5jdXJyZW5jeVN5bWJvbHEAfgADeHB0AANDTll0AAnkurrmsJHluIF0AAPlhYN0AAB0ABvlrp3puKHlmInkv6Hmva7lt57lpKfphZLlupd0AApiYW9qaV8yMjM5fnIAN2NvbS5xdW5hci5ob3RlbC5lYm9va2luZy5yYmFjLm1vZGVsLkVCSG90ZWwkU0hvdGVsTGV2ZWwAAAAAAAAAABIAAHhyAA5qYXZhLmxhbmcuRW51bQAAAAAAAAAAEgAAeHB0AAxMRVZFTDJfT1RIRVJ0AAbpmZXopb90AAkxMDA1MTU2NDhzcgAOamF2YS5sYW5nLkxvbmc7i+SQzI8j3wIAAUoABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhwAAAAAAAIZG54";
        System.out.println(JSON.toJSONString(decode(encrypted)));
    }

    private final static String encode(Object o) {

        if (o instanceof String || o instanceof Integer) {
            return o.toString();
        }
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(o);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != oos)
                    oos.close();
            } catch (IOException e) {
            }
            try {
                if (null != bos)
                    bos.close();
            } catch (IOException e) {
            }
        }
        return Base64.encodeBase64String(bos.toByteArray());
    }

    private final static Object decode(String object) {
        if (null == object) {
            return null;
        }
        Object o = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(Base64.decodeBase64(object));
            ois = new ObjectInputStream(bis);
            o = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return object;
        } finally {
            try {
                if (null != bis)
                    bis.close();
            } catch (IOException e) {
            }
            try {
                if (null != ois)
                    ois.close();
            } catch (IOException e) {
            }
        }
        return o;
    }

}
