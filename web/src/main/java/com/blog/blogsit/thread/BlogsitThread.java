package com.blog.blogsit.thread;

/**
 * 
 * 功能描述：<br>
 * 
 * @author hua.chen 2015年7月31日 下午5:39:39 <br>
 *         修改记录:
 */
public class BlogsitThread extends AbstractBlogsitThread {
    public BlogsitThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        System.out.print("Thread Name:" + getThreadName());

    }

    public static void main(String[] args) throws InterruptedException {
        Thread blolgsit = new Thread(new BlogsitThread("陈华测试线程"));
        blolgsit.sleep(10000);
        blolgsit.start();
    }

}
