package com.blog.blogsit.teample.genericity;

/**
 * 功能描述
 * 人员模型
 *
 * @author hua.chen
 * @create 2016年11月09日11:51
 **/
public class Person<T extends Address,P extends  workexprice> {
    private T address;
    private P workexrice;

    public T getAddress() {
        return address;
    }

    public void setAddress(T address) {
        this.address = address;
    }

    public P getWorkexrice() {
        return workexrice;
    }

    public void setWorkexrice(P workexrice) {
        this.workexrice = workexrice;
    }
}
