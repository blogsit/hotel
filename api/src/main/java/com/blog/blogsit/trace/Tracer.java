package com.blog.blogsit.trace;

import com.blog.blogsit.trace.model.TraceContext;
import com.blog.blogsit.trace.model.TraceId;
import com.blog.blogsit.trace.model.TraceInfo;
import com.blog.blogsit.trace.tools.TraceIdGenerator;

/**
 * 追ID实体类
 *
 * @author hua.chen
 * @date 2017年02月28 16:59
 */
public class Tracer {
    private Tracer() {
    }

    public static TraceInfo initStart(TraceId traceId, String traceTarget) {
        if (traceId == null) {
            TraceIdGenerator.instance.next();
        }
        TraceInfo traceInfo = new TraceInfo(traceId, traceTarget);
        TraceContext.setTraceInfo(traceInfo);
        return traceInfo;
    }

    public static void initEnd() {
        TraceInfo root = TraceContext.getTraceInfo();
        if (root != null) {
            while (true) {
                TraceInfo parentTrace = root.getParentTrace();
                if (parentTrace == null) {
                    break;
                }
                root = parentTrace;
            }
        }
        if (root != null) {
            root.setEndTime(System.currentTimeMillis());
        }
        TraceContext.reset();
    }

    public static TraceInfo remoteStart(String service, String method) {
        TraceInfo traceInfo = TraceContext.getTraceInfo();
        TraceInfo childTrace;
        if (traceInfo == null) {
            childTrace = new TraceInfo(TraceIdGenerator.instance.next(), service + "_" + method);
        } else {
            childTrace = traceInfo.createChildTraceInfo();
        }
        TraceContext.setTraceInfo(childTrace);
        return childTrace;
    }

    public static void remoteEnd() {
        TraceInfo traceInfo = TraceContext.getTraceInfo();
        if (traceInfo == null) {
            return;
        }
        traceInfo.setEndTime(System.currentTimeMillis());
        TraceContext.setTraceInfo(traceInfo.getParentTrace());
    }

    public static TraceId takeTraceId(String clientIP) {
        TraceInfo traceInfo = TraceContext.getTraceInfo();
        if (traceInfo != null) {
            return traceInfo.getTraceId();
        }
        return TraceIdGenerator.instance.next(clientIP);
    }
}
