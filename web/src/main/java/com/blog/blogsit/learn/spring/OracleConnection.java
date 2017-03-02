package com.blog.blogsit.learn.spring;

import javax.activation.DataSource;
/**
 * @author hua.chen 2016年3月15日 下午11:16:05 <br>
 */
public class OracleConnection implements Connection {

    @Override
    public DataSource getDataSouce() {
        // TODO Auto-generated method stub
        System.out.println("获取Oracle数据源");
        return null;
    }

}
