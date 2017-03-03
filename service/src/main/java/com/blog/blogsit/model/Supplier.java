package com.blog.blogsit.model;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商
 *
 * @author hua.chen
 * @date 2017年03月02 11:08
 */
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1821603761871016281L;
    /**
     * 供应商Id
     */
    private long id;
    /**
     * 代理商更新版本号
     */
    private Integer version;
    /**
     * 供应商状态，启用，禁用，删除，待审
     */
    private SupplierStatus status;
    /**
     * 供应商状态切换备注原因
     */
    private String statusLog;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后一次更新时间
     */
    private Date updateTime;

    public String getStatusLog() {
        return statusLog;
    }

    public void setStatusLog(String statusLog) {
        this.statusLog = statusLog;
    }

    public enum SupplierStatus {
        /**
         * 启用
         */
        ENABLED(1, "启用"),
        /**
         * 禁用
         */
        DISABLED(0, "禁用"),
        /**
         * 已删除
         */
        DELETED(-1, "已删除"),
        /**
         * 审核中
         */
        REVIEWING(-2, "审核中"),
        /**
         * 审核未通过
         */
        REJECTED(-3, "审核未通过");

        int code;
        String desc;

        private SupplierStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int code() {
            return code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public static SupplierStatus codeOf(int code) {
            for (SupplierStatus sys : values()) {
                if (sys.getCode() == code) {
                    return sys;
                }
            }
            return null;
        }

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public SupplierStatus getStatus() {
        return status;
    }

    public void setStatus(SupplierStatus status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
