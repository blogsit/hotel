package com.blog.blogsit.arithmetic;

import com.blog.blogsit.arithmetic.frame.HuaRongDao;
import com.blog.blogsit.arithmetic.frame.HuaRongDao;
import com.blog.blogsit.arithmetic.frame.HuaRongDao;

/**
 * Created by blogsit on 16/5/26.
 */
public class TestRabbit {
    public static void main(String[] args) {
        new HuaRongDao();
        narcissisticNumber();
        test13();
        float f1 = 20f;
        float f2 = 20.3f;
        float f3 = 20.5f;
        double d1 = 20d;
        double d2 = 20.3d;
        double d3 = 20.5d;

        System.out.println(f1 == d1);

        System.out.println(f2 == d2);

        System.out.println(f3 == d3);

        //printRabbit(100);
    }

    /**
     * 1 1 2 3 5 8
     *
     * @param month
     */
    public static void printRabbit(int month) {
        int a1 = 1;
        int a2 = 1;
        int mid = 0;
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 2) {
                System.out.println(a1);
            } else {
                System.out.println(a1 + a2);
                mid = a1 + a2;
                a1 = a2;
                a2 = mid;
            }
            System.out.println("iteration:" + printRabbitIteration(i));
        }
    }

    public static int printRabbitIteration(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return printRabbitIteration(month - 1) + printRabbitIteration(month - 2);
        }
    }

    /**
     * 打印水仙花数字
     */
    public static void narcissisticNumber() {
        int a = 0, b = 0, c = 0, data = 0;
        for (int i = 100; i < 999; i++) {
            a = i / 100;
            b = (i - 100 * a) / 10;
            c = i - a * 100 - b * 10;
            data = a * a * a + b * b * b + c * c * c;
            if (data == i) {
                System.out.println("narcissisticNumber" + data);
            }
        }
    }

    public static void  test13(){
        for(int k=1;k<=100000l;k++){
            if(Math.floor(Math.sqrt(k+100))==Math.sqrt(k+100) && Math.floor(Math.sqrt(k+168))==Math.sqrt(k+168))
                System.out.println(k);
        }
    }
}
