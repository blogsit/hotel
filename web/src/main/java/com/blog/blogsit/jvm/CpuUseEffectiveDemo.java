package com.blog.blogsit.jvm;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.google.common.collect.Lists;

/**
 * 
 * 功能描述：<br>
 * 未充分利用CPU:在能并行处理的场景中未使用足够的线程（线程增加：cpu资源消耗可接受且不带来激烈的竞争锁 场景）
 * 
 * @author hua.chen 2015年8月4日 下午2:56:23 <br>
 *         修改记录:
 */
public class CpuUseEffectiveDemo {
    private static int executeTimes = 10;
    private static int taskCount = 200;
    private static final int TASK_THREADCOUNT = 16;
    private static CountDownLatch latch;

    public static void main(String[] args) throws Exception {
        Task[] tasks = new Task[TASK_THREADCOUNT];  
        for (int i = 0; i < TASK_THREADCOUNT; i++) {  
            tasks[i] = new Task();  
        }  
        for (int i = 0; i < taskCount; i++) {  
            int mod = i % TASK_THREADCOUNT;  
            tasks[mod].addTask(Integer.toString(i));  
        } 
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < executeTimes; i++) {  
            System.out.println("Round: " + (i + 1));  
            latch = new CountDownLatch(TASK_THREADCOUNT);  
            for (int j = 0; j < TASK_THREADCOUNT; j++) {  
                Thread thread = new Thread(tasks[j]);  
                thread.start();  
            }  
            latch.await();  
        }  
        long endTime = System.currentTimeMillis();
        System.out.println("Execute summary: Round( " + executeTimes + " ) TaskCount Per Round( " + taskCount
                + " ) Execute Time ( " + (endTime - beginTime) + " ) ms");
    }

    static class Task implements Runnable {
        List<String> tasks = Lists.newArrayList();
        Random random = new Random();
        boolean exitFlag = false;

        public void addTask(String task) {
            List<String> copyTasks = Lists.newArrayList(tasks);
            copyTasks.add(task);
            tasks = copyTasks;
        }

        @Override
        public void run() {
            List<String> runTasks = tasks;
            List<String> removeTasks = Lists.newArrayList();
            for (String task : runTasks) {
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                removeTasks.add(task);
            }
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
