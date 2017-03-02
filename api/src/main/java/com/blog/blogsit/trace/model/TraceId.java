package com.blog.blogsit.trace.model;

import java.io.Serializable;

/**
 * 追踪实体ID
 *
 * @author hua.chen
 * @date 2017年02月28 16:59
 */
public class TraceId implements Serializable{
    private static final long serialVersionUID = 343435544056076639L;

    private String hostIp;

    private long time;

    private int sequence;

    private int flag;

    private int pid;

    public TraceId() {
    }

    public TraceId(String hostIp, long time, int sequence, int pid) {
        this.hostIp = hostIp;
        this.time = time;
        this.sequence = sequence;
        this.flag = 0;
        this.pid = pid;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String asCode() {
        StringBuilder builder = new StringBuilder();
        return builder.append(hostIp).append(time).append(sequence).append(flag).append(pid).toString();
    }
}
