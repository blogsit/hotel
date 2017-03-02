package com.blog.blogsit.learn.reactor;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * 
 * 功能描述：<br>
 * 
 * @author hua.chen 2016年3月13日 上午11:13:04 <br>
 *         修改记录:
 */
public class Handler implements Runnable {
    Socket socket1 = new Socket("127.0.0.1", 6000);
    final SocketChannel socket = socket1.getChannel();
    final SelectionKey sk;

    public Handler(Selector sel) throws IOException {
        socket.configureBlocking(false);
        sk = socket.register(sel, 0);
        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ);
        sel.wakeup();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
    }

}
