package com.blog.blogsit.learn.spring;

import javax.activation.DataSource;
/**
 * @author hua.chen 2016年3月15日 下午11:16:05 <br>
 */
public class MysqlConnection implements Connection {

    @Override
    public DataSource getDataSouce() {
        System.out.println("获取mysql数据源");
        return null;
    }

}
