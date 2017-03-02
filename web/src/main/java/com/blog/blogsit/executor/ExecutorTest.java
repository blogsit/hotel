package com.blog.blogsit.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        ExecutorService executorService = (ExecutorService)executor;
        Runnable test = new Runnable() {
            @Override
            public void run() {
                System.out.println("MY test run");
            }
        };
        executorService.execute(test);
        System.out.println(executorService.isTerminated());
        executor = Executors.newScheduledThreadPool(10);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService)executor;
        Runnable test2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("MY test2 run");
            }
        };
        scheduledExecutorService.schedule(test2, 10, TimeUnit.SECONDS);
    }
}
