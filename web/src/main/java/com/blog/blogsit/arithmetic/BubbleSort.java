package com.blog.blogsit.arithmetic;

public class BubbleSort {
    public static void main(String[] args) {
        int[] score = { 67, 89, 43, 90, 93, 91, 86 };
    }

    /**
     * 
     * 功能描述：<br>
     * 
     * @author hua.chen 2016年2月16日 上午10:44:51 <br>
     *         修改记录:
     */
    public static void bubbleSort(int[] score) {
        long currentTime1 = System.currentTimeMillis();
        for (int i = 0; i < score.length; i++) {
            for (int j = i + 1; j < score.length; j++) {
                // i为前一个 j为后一个。当i的value 大于j的value
                if (score[i] < score[j]) {
                    int mid = score[j];
                    score[j] = score[i];
                    score[i] = mid;
                }
            }
        }
        for (int i = 0; i < score.length; i++) {
            System.out.println("[" + i + "]" + score[i] + ",");
        }
        long currentTime2 = System.currentTimeMillis();
        System.out.println(currentTime2 - currentTime1);
    }

    /**
     * 功能描述：<br>
     * 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数 也是排好顺序的。如此反复循环，直到全部排好顺序。
     * 
     * @param score
     * @author hua.chen 2016年2月16日 上午11:17:13 <br>
     *         修改记录:
     */
    public static void insertSort(int[] score) {
        int temp = 0;
        for (int i = 1; i < score.length; i++) {
            int j = i - 1;
            temp = score[i];
            for (; j < score.length && temp < score[j]; j--) {
                score[j + 1] = score[j];
            }
            score[j + 1] = temp;
        }
        for (int i = 0; i < score.length; i++) {
            System.out.println("[" + i + "]" + score[i] + ",");
        }
    }
}
