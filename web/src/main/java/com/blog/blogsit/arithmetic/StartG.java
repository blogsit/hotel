package com.blog.blogsit.arithmetic;

/**
 * Created by blogsit on 16/8/15.
 */
public class StartG {
    public static void main(String[] args) {
        startG2();
        startG1();
        System.out.println(total(9));
    }

    /**
     * 三角形
     */
    public static void startG2() {
        int i, j = 0;
        for (i = 1; i <= 5; i++) {
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (i = 5; i >= 1; i--) {
            for (j = 1; j <= 2 * i - 3; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    /**
     * 菱行
     */
    public static void startG1() {
        int i, j, k = 0;
        for (i = 1; i <= 5; i++) {
            for (k = 1; k <= 5 - i; k++) {
                System.out.print(" ");
            }
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (i = 5; i >= 1; i--) {
            for (k = 1; k <= 6 - i; k++) {
                System.out.print(" ");
            }
            for (j = 1; j <= 2 * i - 3; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    /**
     * 题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个   第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下   的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
     1.程序分析：采取逆向思维的方法，从后往前推断
     * @param day
     * @return
     */
    public static int total(int day) {
        if (day == 10) {
            return 1;
        } else {
            return (total(day + 1) + 1) * 2;
        }
    }

}
