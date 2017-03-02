package com.blog.blogsit.executor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.LogFactory;

/**
 * 
 * 功能描述：<br>
 * 
 * @author hua.chen 2016年1月26日 下午4:15:51 <br>
 *         修改记录:
 */
public class SocketClientRequestThread implements Runnable {
    static {
    }

    private static final org.apache.commons.logging.Log LOGGER = LogFactory.getLog(SocketClientRequestThread.class);
    private CountDownLatch countDownLatch;
    private Integer clientIndex;

    public SocketClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) {
        this.countDownLatch = countDownLatch;
        this.clientIndex = clientIndex;
    }

    public void run() {
        Socket socket;
        try {
            socket = new Socket("127.0.0.1", 83);
            OutputStream clientRequest = socket.getOutputStream();
            InputStream clientResponse = socket.getInputStream();
            this.countDownLatch.wait();
            clientRequest.write(("This is " + this.clientIndex + " client 请求。").getBytes());
            clientRequest.flush();
            //在这里等待，直到服务器返回信息
            SocketClientRequestThread.LOGGER.info("第" + this.clientIndex + "个客户端的请求发送完成，等待服务器返回信息");
            int maxLen = 1024;
            byte[] contextBytes = new byte[maxLen];
            int realLen;
            String message = "";
            //程序执行到这里，会一直等待服务器返回信息（注意，前提是in和out都不能close，如果close了就收不到服务器的反馈了）
            while((realLen = clientResponse.read(contextBytes, 0, maxLen)) != -1) {
                message += new String(contextBytes , 0 , realLen);
            }
            SelectorProvider selectorProvider = SelectorProvider.provider();
            SocketClientRequestThread.LOGGER.info("接收到来自服务器的信息:" + message);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}