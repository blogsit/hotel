package com.blog.blogsit.thread;

import java.util.Date;

public class TestStr {
    public static void main(String[] args) {
        if (true) {
            UID uid = new UID();
            while(true){
                System.out.println(uid.next());
            }
        } else if (true) {
            System.out.println("1");
        } else {
            System.out.println("1");
        }
    }
}
