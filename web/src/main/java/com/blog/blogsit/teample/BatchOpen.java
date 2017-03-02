package com.blog.blogsit.teample;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 批量开放算法
 *
 * @author hua.chen
 * @date 2016年12月24 00:19
 */
public class BatchOpen {
    private static int hundredPrecent = 100;
    private static List<String> whileList = Lists.newArrayList("kfoj2400", "com/blog/blogsit/arithmetic/blogsit");

    public static void main(String[] args) {
        int j  =0;
        for (int i = 0; i < 100; i++) {
            String userName = "test"+i;
            long hashCode = userName.hashCode();
            long positiveHashCode = Math.abs(hashCode);
            boolean canConntection = positiveHashCode % hundredPrecent < 50;
            if (canConntection) {
                j=j+1;
                System.out.println("命中的用户名:" + userName+"__"+j);
            }
        }
    }
}
