package com.blog.blogsit.util;

import com.blog.blogsit.teample.genericity.Address;
import org.apache.commons.beanutils.BeanUtilsBean;

/**
 * 功能描述
 * 实体操作类
 *
 * @author hua.chen
 * @create 2016年11月15日11:43
 **/
public class BeanUtils {
    public static <T> T cloneBean(T sourceBean) {
        try {
            return (T) BeanUtilsBean.getInstance().cloneBean(sourceBean);
        } catch (Exception e) {
            throw new RuntimeException("error when clone bean", e);
        }
    }

    public static void main(String[] args) {
        Address address = new Address();
        address.setCity("北京");
        address.setTown("海淀区苏州街");
        Address address1 = cloneBean(address);
        address1.setTown("维亚大厦");
        System.out.println(address1);
        System.out.println(address == address1);
        System.out.println(address.getCity().equals(address1.getCity()));
        System.out.println(address.compareTo(address1));
    }
}
