package com.blog.blogsit.thread;

/**
 * 
 * 功能描述：<br>
 * 抽象类
 * 
 * @author hua.chen 2015年7月31日 下午5:37:12 <br>
 *         修改记录:
 */
public abstract class AbstractBlogsitThread implements Runnable {
    /**
     * 线程名称
     */
    private String threadName;

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public AbstractBlogsitThread() {
        super();
    }

    public AbstractBlogsitThread(String threadName) {
        super();
        this.threadName = threadName;
    }

    @Override
    public void run() {

    }

}
