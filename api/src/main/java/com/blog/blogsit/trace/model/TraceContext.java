package com.blog.blogsit.trace.model;

/**
 * 追踪线程上下文
 *
 * @author hua.chen
 * @date 2017年02月28 17:02
 */
public class TraceContext {
    private static final ThreadLocal<TraceInfo> traceInfoThreadLocal = new ThreadLocal<TraceInfo>();

    public static void setTraceInfo(TraceInfo traceInfo) {
        traceInfoThreadLocal.set(traceInfo);
    }

    public static void reset() {
        traceInfoThreadLocal.set(null);
    }

    public static TraceInfo getTraceInfo() {
        return traceInfoThreadLocal.get();
    }

}
