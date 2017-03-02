package com.blog.blogsit.learn.reactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 功能描述：<br>
 * 由一个不断等待和循环的单独进程（线程）来做这件事，它接受所有handler的注册，<br>
 * 并负责先操作系统查询IO是否就绪，在就绪后就调用 指定handler进行处理，这个角色的名字就叫做Reactor
 * 
 * @author hua.chen 2016年3月13日 上午11:12:04 <br>
 *         修改记录:
 */
public class Reactor implements Runnable {
    Selector selector;

    public Reactor() throws IOException {
        selector = Selector.open();
    }

    @Override
    public void run() {
        try {
            while (true) {
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext()) {
                    dispatch((SelectionKey) it.next());
                    selected.clear();
                }
            }

        } catch (IOException ex) {

        }
    }

    void dispatch(SelectionKey k) {
        Runnable r = (Runnable) (k.attachment());
        if (r != null) {
            r.run();
        }
    }
}
