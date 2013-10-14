/*
 * Order.java 2012-2-9
 * 智域工作室
 */
package net.intellizone.coupon.order.model;

import java.util.List;

import net.intellizone.coupon.user.model.User;

import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

/**
 * 订单类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Table("iz_order")
public class Order {
	// 主键id
	@Column("order_id")
	@Prev(@SQL(db = DB.MYSQL, value = "select MAX(order_id) from iz_order"))
	@Id
	private long id;

	@Column("user_id")
	private long userId;
	

	@One(target = User.class, field = "userId")
	private User user;



	@Column("create_time")
	private long createTime;

	@Column("modify_time")
	private long modifyTime;

	@Column("order_status")
	private int orderStatus;

	@Column("sysflag")
	private int sysFlag;

	@Column("order_type")
	private int orderType;
	
	@Column("ORDER_NO")
	private String orderNo;
	
	@Column("order_req_tran_seq")
	private String orderReqTranSeq;
	
	@Column("cur_type")
	private String curType;
	
	@Column("encode_type")
	private String encodeType;
	
	@Column("bank_id")
	private String bankId;
	
	@Column("up_tran_seq")
	private String upTranSeq;
	
	@Column("tran_date")
	private String tranDate;
	
	@Column("retn_code")
	private String retnCode;
	
	@Column("retn_info")
	private String retnInfo;
	
	@Column("sign")
	private String sign;
	
	@Column("order_amount")
	private double orderAmount;
	
	@Column("attach_amount")
	private double attachAmount;
	
	@Column("product_amount")
	private double productAmount;
	
	@Many(target = OrderItem.class, field = "order_id")
	private List<OrderItem> orderItemList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(int sysFlag) {
		this.sysFlag = sysFlag;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderReqTranSeq() {
		return orderReqTranSeq;
	}

	public void setOrderReqTranSeq(String orderReqTranSeq) {
		this.orderReqTranSeq = orderReqTranSeq;
	}

	public String getCurType() {
		return curType;
	}

	public void setCurType(String curType) {
		this.curType = curType;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getUpTranSeq() {
		return upTranSeq;
	}

	public void setUpTranSeq(String upTranSeq) {
		this.upTranSeq = upTranSeq;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getRetnCode() {
		return retnCode;
	}

	public void setRetnCode(String retnCode) {
		this.retnCode = retnCode;
	}

	public String getRetnInfo() {
		return retnInfo;
	}

	public void setRetnInfo(String retnInfo) {
		this.retnInfo = retnInfo;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getEncodeType() {
		return encodeType;
	}

	public void setEncodeType(String encodeType) {
		this.encodeType = encodeType;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public double getAttachAmount() {
		return attachAmount;
	}

	public void setAttachAmount(double attachAmount) {
		this.attachAmount = attachAmount;
	}

	public long getUseId() {
		return userId;
	}

	public void setUseId(long userId) {
		this.userId = userId;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
}
