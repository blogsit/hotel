package com.blog.blogsit.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.collections.LRUMap;

/**
 * 日期工具
 *
 * @author: hua.chen
 * @date 14-11-18 上午11:33
 */
public class DateUtil {
    
    public static final String YYYY_MM_dd_HHMMSS_NORMAL = "yyyy-MM-dd HH:mm:ss"; // 日期格式
    public static final String YYYY_MM_dd = "yyyy-MM-dd"; // 年月日格式
    public static final String YYYYMMdd = "yyyyMMdd"; // 年月日格式
    public static final int DAYSBETWEEN_180 =180;

    /**
     * 当前日期是星期几
     */
    public static int nowForWeek() {
        Calendar c = Calendar.getInstance();
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    /**
     * 获取当前日期的本星期一00:00:00
     */
    public static long getPreMonday(){
        return getMonday(2);
    }

    /**
     * 获取当前日期的下星期一00:00:00
     */
    public static long getNextMonday(){
        return getMonday(9);
    }

    /**
     * 获取星期一00:00:00
     */
    private static long getMonday(int daynum) {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int lastMonday = c.get(Calendar.DATE) - dayOfWeek + daynum;
        c.set(Calendar.DATE, lastMonday);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTimeInMillis();
    }

    /**
     * 获取当前日期的本星期一00:00:00
     */
    public static Date getThisMonday() {
        return new Date(getMonday(2));
    }

    /**
     * 返回中文星期
     *
     * @param num
     * @return
     */
    public static String getWeekCn(int num) {
        String[] ch_Chars = new String[]{"日", "一", "二", "三", "四", "五", "六"};
        return 0 <= num && num <= 6 ? ch_Chars[num] : String.valueOf(num);
    }

    /**
     * 当天的剩余秒数
     *
     * @return
     */
    public static int remainingSecondInToday() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);// 小时
        int minute = cal.get(Calendar.MINUTE);// 分           
        int second = cal.get(Calendar.SECOND);// 秒
        return (24 * 3600) - hour * 3600 - minute * 60 - second;
    }

    public static Date nextDate(Date date) {
        return moveDate(date, 1);
    }

    public static Date prevDate(Date date) {
        return moveDate(date, -1);
    }

    private static Date moveDate(Date date, int d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, d);
        return cal.getTime();
    }
    /**
     * 功能描述：<br>
     *  转换为时间
     * @param candidateDateStr 时间
     * @param format 时间格式
     * @return
     */
    public static Date parse(String candidateDateStr, String format) throws ParseException {
        return getDateFormat(format).parse(candidateDateStr);
    }
    
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
    
    /**
     * 功能描述：<br>
     *
     * @param date 时间
     * @param dataFormat 时间格式
     * @return
     */
    public static String format(Date date, String dataFormat) {
        return getDateFormat(dataFormat).format(date);
    }
    
    /**
     * 功能描述：<br>
     * 按日历类型进行增加
     * @param date 需要处理的时间
     * @param calendarType 日期类型
     * @param count 数量
     * @return 
     */
    public static Date add(Date date, int calendarType, int count) {
        if (count == 0) {
            return date;
        }
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarType, count);
        return c.getTime();
    }
    
    /**
     * 功能描述：<br>
     * 按日历类型进行减少
     * @param date 需要处理的时间
     * @param calendarType 日期类型
     * @param count 数量
     * @return 
     */
    public static Date sub(Date date, int calendarType, int count) {
        return add(date, calendarType, -1 * count);
    }
    
    private static final int MAX_SDF_SIZE = 20;
    private static final ThreadLocal<LRUMap> dateFormatThreadLocal = new ThreadLocal<LRUMap>() {
        @Override
        protected LRUMap initialValue() {
            return new LRUMap(MAX_SDF_SIZE);
        }
    };
    public static void main(String[] args) {
        int a = 4;
        System.out.println(++a);
    }
}
