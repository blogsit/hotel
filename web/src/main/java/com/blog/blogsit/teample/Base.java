package com.blog.blogsit.teample;

/**
 * 基础类
 *
 * @author hua.chen
 * @date 2017年02月23 18:50
 */
public class Base {
    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class childBase extends Base {
        private  String baseName = "childBase";

        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base base = new childBase();
    }
}
