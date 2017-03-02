package com.blog.blogsit.util;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

/**
 * 
 * 功能描述：<br>
 * 字符串处理类
 * 
 * @author hua.chen 2015年7月1日 下午7:29:27 <br>
 *         修改记录:
 */
public class StringUtil {

    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public static boolean getBooleanValue(String value, boolean defaultVal) {
        if (StringUtils.isBlank(value)) {
            return defaultVal;
        }
        boolean result = defaultVal;
        try {
            result = Boolean.parseBoolean(value);
        } catch (Exception e) {
            logger.error("getBooleanValue exception:", e);
        }
        return result;
    }

    public static int getIntValue(String value, int defaultVal) {
        if (StringUtils.isBlank(value)) {
            return defaultVal;
        }
        int result = defaultVal;
        try {
            result = Integer.parseInt(value);
        } catch (Exception e) {
            logger.error("getIntValue exception:", e);
        }
        return result;
    }

    public static long getLongValue(String value, long defaultVal) {
        if (StringUtils.isBlank(value)) {
            return defaultVal;
        }
        long result = defaultVal;
        try {
            result = Long.parseLong(value);
        } catch (Exception e) {
            logger.error("getLongValue exception:", e);
        }
        return result;
    }

    public static double getDoubleValue(String value, double defaultVal) {
        if (StringUtils.isBlank(value)) {
            return defaultVal;
        }
        double result = defaultVal;
        try {
            result = Double.parseDouble(value);
        } catch (Exception e) {
            logger.error("getDoubleValue exception:", e);
        }
        return result;
    }

    public static boolean isInteger(String value) {
        boolean flag = true;
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static String arrayToString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static String[] trimToArray(String content, String token) {
        String[] result = ArrayUtils.EMPTY_STRING_ARRAY;
        content = StringUtils.trimToEmpty(content);
        if (StringUtils.isNotEmpty(content)) {
            result = StringUtils.trim(content).split(token);
            for (int i = 0; i < result.length; i++) {
                if (result[i] == null || "".equals(result[i].trim().toString())) {
                    result = (String[]) ArrayUtils.remove(result, i);
                }
            }

        }
        return result;
    }

    public static List<Integer> transform(String[] values) {
        if (values == null || values.length == 0) {
            return Lists.newArrayList();
        }
        List<Integer> iList = Lists.newArrayList();
        for (String value : values) {
            Integer i = Integer.parseInt(value);
            iList.add(i);
        }
        return iList;
    }

}
