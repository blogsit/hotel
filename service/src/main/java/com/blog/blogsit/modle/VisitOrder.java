package com.blog.blogsit.modle;

import java.util.Date;

/**
 * 
 * 功能描述：<br>
 * 订单模型
 * 
 * @author hua.chen 2015年6月29日 下午4:32:14 <br>
 *         修改记录:
 */
public class VisitOrder {
    private Integer id;
    // 用户ID
    private Integer userId;
    // 用户名
    private String userName;
    // 是否审核
    private Integer isAudit = 0;
    // 消费者
    private String customer;
    // 地址
    private String address;
    // 上面服务时间
    private Date visitingTime;
    // 订单创建时间
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(Integer isAudit) {
        this.isAudit = isAudit;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(Date visitingTime) {
        this.visitingTime = visitingTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
