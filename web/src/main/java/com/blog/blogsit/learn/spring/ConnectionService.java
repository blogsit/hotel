package com.blog.blogsit.learn.spring;

import javax.activation.DataSource;
/**
 * @author hua.chen 2016年3月15日 下午11:16:05 <br>
 */
public class ConnectionService implements Connection {
    public Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public DataSource getDataSouce() {
        return connection.getDataSouce();
    }

}
