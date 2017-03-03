package com.blog.blogsit.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EBooking订单
 * 
 * @author shuwen.lan
 * 
 */
public class EBookingOrder {

    private int id;
    // 订单号
    private String orderNo;
    // 酒店ID
    private int hotelId;
    // 酒店SEQ
    private String hotelSeq;
    // 酒店名称
    private String hotelName;
    // 酒店英文名称
    private String enHotelName;
    // 酒店前台电话
    private String hotelPhone;
    // 酒店城市ID
    private String cityId;
    // 酒店城市名称
    private String cityName;
    // 供应商ID
    private long supplierId;
    // 产品房型ID
    private long roomId;
    // 产品房型名称
    private String roomName;
    // 产品房型英文名称
    private String enRoomName;
    // 预订的房间数量
    private int roomNum;
    // 订单状态
    private int status;
    // 订单状态描述
    private String statusDesc;
    // 下单来源
    private String source;
    // 入住日期
    private Date fromDate;
    // 离店日期
    private Date toDate;
    // 下单时间
    private Date orderDate;
    // 入住人姓名，多个入住人用|隔开
    private String customerNames;
    // 联系人姓名
    private String contactName;
    // 联系人手机号
    private String contactMobile;
    // wrapperId
    private String wrapperId;
    // 订单类型
    private int orderType;
    // 订单类型描述
    private String orderTypeDesc;
    // 业务类型
    private int bizType;
    // 业务类型描述
    private String bizTypeDesc;
    // 销售渠道
    private String saleChannel;
    // 担保类型：-1全部 1.非担保，2担保，3直连非担保
    private int guaranteeType;
    // 订单总金额
    private BigDecimal priceAmount;
    // 担保金额
    private BigDecimal guaranteeAmount;
    // 预付金额
    private BigDecimal prepaidAmount;
    // 支付类型  0现付 1前台现付
    private int payType;
    // 是否是预留房
    private int isComputerRoom;
    // 特殊说明
    private String remark;
    // 到店时间
    private String arrivalTime;
    // 价格详情
    private String priceDetail;
    // 订单标记:bit0-微信订单,bit1-现付转预付,bit2-手机专享订单,bit3-eb前台拉新订单
    private int orderFlag;
    // 原数据库中各个业务订单的自增id
    private long originalId;
    // 订单原始状态
    private int originalStatus;
    // 按钮
    private List<String> buttons;
    // 扩展信息
    private Map<String, Object> extInfoMap = new HashMap<String, Object>();
    // fromDate的字符串格式（用于客户端展示）
    private String fromDateStr;
    // toDate的字符串格式（用于客户端展示）
    private String toDateStr;
    // orderDate的字符串格式（用于客户端展示）
    private String orderDateStr;
    // 是否是微信订单（用于前端展示）
    private boolean isWechatOrder;
    // 是否是手机专享（用于前端展示）
    private boolean isMobileVip;
    // 订单处理状态 （用于前端展示）
    private int processStatus;
    private String processStatusDesc;
    // 是否是买断房（用于前端展示）
    private boolean isBuyOut;
    // 是否扫码单（用于前端展示）
    private boolean codePay;
    // 是否重发EB订单（用于前端展示）
    private boolean retryEBOrder;
    // 是否变更订单（用于前端展示）
    private boolean orderChanged;
    // 是否紧急订单（用于前端展示）
    private boolean rushOrder;
    // 前台可查订单标记(用于前端展示默认-1 前端不显示)
    private int frontDeskQuery = -1;
    // 订单版本号
    private int version;
    //钟点房 入住时间
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date fromTime;
    //钟点房离店时间
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date toTime;

    public boolean isOcncType() {
        return (orderFlag & 0x02) > 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelSeq() {
        return hotelSeq;
    }

    public void setHotelSeq(String hotelSeq) {
        this.hotelSeq = hotelSeq;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getEnHotelName() {
        return enHotelName;
    }

    public void setEnHotelName(String enHotelName) {
        this.enHotelName = enHotelName;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long productId) {
        this.roomId = productId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getEnRoomName() {
        return enRoomName;
    }

    public void setEnRoomName(String enRoomName) {
        this.enRoomName = enRoomName;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerNames() {
        return customerNames;
    }

    public void setCustomerNames(String customerNames) {
        this.customerNames = customerNames;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getWrapperId() {
        return wrapperId;
    }

    public void setWrapperId(String wrapperId) {
        this.wrapperId = wrapperId;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getOrderTypeDesc() {
        return orderTypeDesc;
    }

    public void setOrderTypeDesc(String orderTypeDesc) {
        this.orderTypeDesc = orderTypeDesc;
    }

    public int getBizType() {
        return bizType;
    }

    public void setBizType(int bizType) {
        this.bizType = bizType;
    }

    public String getBizTypeDesc() {
        return bizTypeDesc;
    }

    public void setBizTypeDesc(String bizTypeDesc) {
        this.bizTypeDesc = bizTypeDesc;
    }

    public String getSaleChannel() {
        return saleChannel;
    }

    public void setSaleChannel(String saleChannel) {
        this.saleChannel = saleChannel;
    }

    public int getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(int guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public BigDecimal getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(BigDecimal priceAmount) {
        this.priceAmount = priceAmount;
    }

    public BigDecimal getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    public BigDecimal getPrepaidAmount() {
        return prepaidAmount;
    }

    public void setPrepaidAmount(BigDecimal prepaidAmount) {
        this.prepaidAmount = prepaidAmount;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getIsComputerRoom() {
        return isComputerRoom;
    }

    public void setIsComputerRoom(int isComputerRoom) {
        this.isComputerRoom = isComputerRoom;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getPriceDetail() {
        return priceDetail;
    }

    public void setPriceDetail(String priceDetail) {
        this.priceDetail = priceDetail;
    }

    public int getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(int orderFlag) {
        this.orderFlag = orderFlag;
    }

    public long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(long originalId) {
        this.originalId = originalId;
    }

    public int getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(int originalStatus) {
        this.originalStatus = originalStatus;
    }

    public List<String> getButtons() {
        return buttons;
    }

    public void setButtons(List<String> buttons) {
        this.buttons = buttons;
    }

    public Map<String, Object> getExtInfoMap() {
        return extInfoMap;
    }

    public void setExtInfoMap(Map<String, Object> extInfoMap) {
        this.extInfoMap = extInfoMap;
    }

    public String getToDateStr() {
        return toDateStr;
    }

    public void setToDateStr(String toDateStr) {
        this.toDateStr = toDateStr;
    }

    public String getOrderDateStr() {
        return orderDateStr;
    }

    public void setOrderDateStr(String orderDateStr) {
        this.orderDateStr = orderDateStr;
    }

    public String getFromDateStr() {
        return fromDateStr;
    }

    public void setFromDateStr(String fromDateStr) {
        this.fromDateStr = fromDateStr;
    }

    public boolean isWechatOrder() {
        return isWechatOrder;
    }

    public void setWechatOrder(boolean wechatOrder) {
        isWechatOrder = wechatOrder;
    }

    public boolean isMobileVip() {
        return isMobileVip;
    }

    public void setMobileVip(boolean mobileVip) {
        isMobileVip = mobileVip;
    }

    public int getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(int processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessStatusDesc() {
        return processStatusDesc;
    }

    public void setProcessStatusDesc(String processStatusDesc) {
        this.processStatusDesc = processStatusDesc;
    }

    public boolean isRetryEBOrder() {
        return retryEBOrder;
    }

    public void setRetryEBOrder(boolean retryEBOrder) {
        this.retryEBOrder = retryEBOrder;
    }

    public boolean isBuyOut() {
        return isBuyOut;
    }

    public void setBuyOut(boolean buyOut) {
        isBuyOut = buyOut;
    }

    public boolean isOrderChanged() {
        return orderChanged;
    }

    public void setOrderChanged(boolean orderChanged) {
        this.orderChanged = orderChanged;
    }

    public boolean getCodePay() {
        return codePay;
    }

    public void setCodePay(boolean isCodePay) {
        this.codePay = isCodePay;
    }

    public boolean isRushOrder() {
        return rushOrder;
    }

    public void setRushOrder(boolean rushOrder) {
        this.rushOrder = rushOrder;
    }

    public int getFrontDeskQuery() {
        return frontDeskQuery;
    }

    public void setFrontDeskQuery(int frontDeskQuery) {
        this.frontDeskQuery = frontDeskQuery;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }
}
