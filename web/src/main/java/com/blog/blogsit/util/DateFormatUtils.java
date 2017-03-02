/**
 * 
 */
package com.blog.blogsit.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.collections.map.LRUMap;

/**
 * 功能描述：<br>
 * 
 * @author hua.chen 2014-7-9 下午5:27:11 <br>
 */
public class DateFormatUtils {

    private static final int MAX_SDF_SIZE = 20;
    private static final ThreadLocal<LRUMap> dateFormatThreadLocal = new ThreadLocal<LRUMap>() {
        @Override
        protected LRUMap initialValue() {
            return new LRUMap(MAX_SDF_SIZE);
        }
    };

    public static SimpleDateFormat getDateFormat(String pattern) {
        LRUMap sdfMap = dateFormatThreadLocal.get();
        SimpleDateFormat sdf = (SimpleDateFormat) sdfMap.get(pattern);
        if (sdf == null) {
            sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            sdfMap.put(pattern, sdf);
        }
        return sdf;
    }

    public static void destory() {
        dateFormatThreadLocal.remove();
    }

    public static Date parse4y2M2d(String source) {
        try {
            return getDateFormat("yyyy-MM-dd").parse(source);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parseyyyyMMdd(String source) {
        try {
            return getDateFormat("yyyyMMdd").parse(source);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parse4y2M2d2h2m2s(String source) {
        try {
            return getDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
        } catch (Exception e) {
            return null;
        }
    }

    public static String format4y2M2d(Date date) {
        return getDateFormat("yyyy-MM-dd").format(date);
    }

    public static String formatyyyyMMdd(Date date) {
        return getDateFormat("yyyyMMdd").format(date);
    }

    public static String format4y2M2d2h2m2s(Date date) {
        return getDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String format2h2m2s(Date date) {
        return getDateFormat("HH:mm:ss").format(date);
    }

    public static String format4y2M2d2h2m(Date date) {
        return getDateFormat("yyyy-MM-dd HH:mm").format(date);
    }

    public static String format4y2M2d2h2m2sChn(Date date) {
        return getDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
    }

    public static String format2M2dChn(Date date) {
        return getDateFormat("MM月dd日").format(date);
    }
}
