package com.blog.blogsit.trace.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 追踪类型实体
 *
 * @author hua.chen
 * @date 2017年02月28 17:03
 */
public class TraceInfo implements Serializable{
    private static final long serialVersionUID = -233082342342342342L;
    private TraceId traceId;
    private String  path;
    private String target;
    private long beginTime;
    private long endTime;
    private TraceInfo parentTrace;
    private AtomicInteger currentLevelIndex = new AtomicInteger();
    public TraceInfo(){

    }
    public TraceInfo(TraceId traceId, String traceTarget) {
        this(traceId, traceTarget, TraceConfig.ROOT_PATH);
    }
    public TraceInfo(TraceId traceId, String traceTarget, String path) {
        this(traceId, traceTarget, path, null);
    }
    public TraceInfo(TraceId traceId, String traceTarget, String path, TraceInfo parentTrace) {
        this.traceId = traceId;
        this.target = traceTarget;
        this.path = path;
        this.beginTime = System.nanoTime();
        this.parentTrace = parentTrace;
    }
    public String asTraceCode() {
        return traceId.asCode() + "~" + this.path;
    }
    public TraceInfo createChildTraceInfo() {
        return new TraceInfo(getTraceId(), getTarget(), nextCurrentLevelPath(), this);
    }

    private String nextCurrentLevelPath() {
        return getPath() + "." + currentLevelIndex.incrementAndGet();
    }
    public TraceId getTraceId() {
        return traceId;
    }

    public void setTraceId(TraceId traceId) {
        this.traceId = traceId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public TraceInfo getParentTrace() {
        return parentTrace;
    }

    public void setParentTrace(TraceInfo parentTrace) {
        this.parentTrace = parentTrace;
    }
}
