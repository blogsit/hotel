package com.blog.blogsit.trace.tools;

import com.blog.blogsit.trace.model.TraceId;
import static com.blog.blogsit.trace.tools.TraceTools.*;

/**
 * @author hua.chen
 * @date 2017年02月28 17:29
 */
public enum TraceIdGenerator {
    instance;

    public TraceId next() {
        return next(null);
    }

    public TraceId next(String clientIP) {
        String ip = currentPrivateIp(clientIP);
        long time = currentTime();
        int sequence = sequenceNum();
        int pid = currentPid();
        return new TraceId(ip, time, sequence, pid);
    }
}
