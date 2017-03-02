package com.blog.blogsit.daily;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * daily coding String
 *
 * @author hua.chen
 * @date 2017年02月25 23:13
 */
public class String20170226 {
    /**
     * Integer缓存了1-127~127的整数.所以cd 相等 ab不相等
     *
     * @param atr
     */
    public static void main(String[] atr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
        Integer a = 1000, b = 1000;
        Integer c = 100, d = 100;
        System.out.println(a == b);
        System.out.println(c == d);
        String20170226 string20170226 = new String20170226();
        string20170226.testTemplate();

    }

    public void testTemplate() {
        String monitorKey = "currentDate";
        String currentDate = new BizExeTemplate<String>(monitorKey) {
            @Override
            protected String process() throws Exception {
                return genString();
            }
        }.execute();
    }

    public String genString() {
        return "chenhua";
    }

    /**
     * 方法执行模板
     *
     * @param <T>
     */
    public abstract class BizExeTemplate<T> {
        //one step 记录日志
        private String monitorKey;

        public BizExeTemplate(String monitorKey) {
            Preconditions.checkArgument(StringUtils.isNotBlank(monitorKey), "monitorKey must not blank");
            this.monitorKey = monitorKey;
        }

        public T execute() {
            try {
                long start = System.nanoTime();
                T result = process();
                long time = System.nanoTime() - start;
                System.out.println(monitorKey + " success " + time);
                onSuccess();
                return result;
            } catch (Exception e) {
                // invoke
                System.out.println(monitorKey + " failed");
                onFail();
                return null;
            } finally {
                // invoke
                System.out.println(monitorKey + " invoke");
            }
        }

        protected abstract T process() throws Exception;

        protected void onSuccess() {
        }

        protected void onFail() {
        }
    }
}
