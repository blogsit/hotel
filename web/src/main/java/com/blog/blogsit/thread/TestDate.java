package com.blog.blogsit.thread;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


public class TestDate {
    public static void main(String[] args) throws ParseException {
        
        Calendar createTimeCalender = Calendar.getInstance();
        createTimeCalender.add(Calendar.DATE, -4);

        String[] formater = { "yyyy-MM-dd" };
        
        Date createDate = DateUtils.parseDate(DateFormatUtils.format(createTimeCalender.getTime(), "yyyy-MM-dd"), formater);
        Date todayDate = DateUtils.parseDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd"),formater);
       
        Calendar createCalender = Calendar.getInstance();
        createCalender.setTime(createDate);
        
        Calendar createCalenderAdd = Calendar.getInstance();
        createCalenderAdd.setTime(createDate);
        createCalenderAdd.add(Calendar.DATE, 3);

        Calendar today = Calendar.getInstance();
        today.setTime(todayDate);
        
        if (today.getTimeInMillis() - createCalender.getTimeInMillis() >= 0
                && createCalenderAdd.getTimeInMillis() - today.getTimeInMillis() >= 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        
        //当天6:00到24:00
        Calendar todayDateAddSix = Calendar.getInstance();
        todayDateAddSix.setTime(todayDate);
        todayDateAddSix.add(Calendar.HOUR_OF_DAY, 6);
        
        Calendar todayDateAddDay = Calendar.getInstance();
        todayDateAddDay.setTime(todayDate);
        todayDateAddDay.add(Calendar.DATE, 1);
        todayDateAddDay.add(Calendar.HOUR_OF_DAY, 6);
        System.out.println(DateFormatUtils.format(todayDateAddSix.getTime(), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateFormatUtils.format(todayDateAddDay.getTime(), "yyyy-MM-dd HH:mm:ss"));

    }
}
