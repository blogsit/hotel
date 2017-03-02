package com.blog.blogsit.learn.spring;

/**
 * 测试类
 * 
 * @author hua.chen 2016年3月15日 下午11:38:44 <br>
 */
public class IocTestClient {
    public static void main(String[] args) {
        IocContainer container = new IocContainer();
        Connection connection = (Connection) container.getComponent("connectionService");
        connection.getDataSouce();
    }
}
