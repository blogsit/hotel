package com.blog.blogsit.trace.tools;


import org.apache.commons.lang3.StringUtils;

import java.lang.management.ManagementFactory;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hua.chen
 * @date 2017年02月28 17:29
 */
public class TraceTools {
    private static SequenceNum sequenceNum = new SequenceNum();


    private static final int currentPid;

    private static final String privateIp;

    static {

        currentPid = getCurrentPid();
        privateIp = getPrivateIP();
    }

    /**
     * 获取当前进程PID
     *
     * @return
     */
    public static int currentPid() {
        return currentPid;
    }

    /**
     * 获取0-15的递增数.
     *
     * @return
     */
    public static int sequenceNum() {
        return sequenceNum.next();
    }

    /**
     * 获取当前时间.
     *
     * @return
     */
    public static long currentTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获取host私有ip地址.
     *
     * @return
     * @param clientIP
     */
    public static String currentPrivateIp(String clientIP) {

        if (clientIP == null) {
            return privateIp;
        }

        return asHexString(clientIP);

    }


    public static class SequenceNum {

        private AtomicInteger offset = new AtomicInteger(1000);

        public int next() {
            while (true) {
                int current = offset.get();
                int next = (current > 9500) ? 1000 : current + 1;
                if (offset.compareAndSet(current, next)) {
                    return next;
                }
            }
        }

    }

    public static String getPrivateIP() {

        InetAddress inetAddress = _getPrivateIP();

        if (inetAddress == null) {
            return "ffffffff";
        }

        return asHexString(inetAddress.getHostAddress());

    }

    private static String asHexString(String ip) {
        String[] ips = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String column : ips) {
            String hex = Integer.toHexString(Integer.parseInt(column));
            if (hex.length() == 1) {
                sb.append('0').append(hex);
            } else {
                sb.append(hex);
            }

        }
        return sb.toString();
    }

    private static InetAddress _getPrivateIP() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            List<InetAddress> addresses = new ArrayList<InetAddress>();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();


                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        if (StringUtils.startsWith(inetAddress.getHostAddress(), "192.168.")) {
                            return inetAddress;
                        }
                    }
                }
            }

            return null;
        } catch (SocketException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static int getCurrentPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (StringUtils.isEmpty(name)) {
            return 0;
        }

        String[] split = name.split("@");

        try {
            return Integer.parseInt(split[0]);
        } catch (Exception e) {
            return 0;
        }
    }
}
