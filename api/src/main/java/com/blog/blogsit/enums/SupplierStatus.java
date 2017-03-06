package com.blog.blogsit.enums;

/**
 * @author hua.chen
 * @date 2017年03月05 21:38
 */
public enum SupplierStatus  implements EnumTrait{
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