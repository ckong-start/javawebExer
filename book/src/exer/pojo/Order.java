package exer.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	private String orderId;//订单号==流水号
	private Date createTime;//订单日期
	private BigDecimal totalPrice;//订单金额
	private Integer status;//订单状态	0未发货，1已发货，2已收货
	private Integer userId;//用户编号
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", createTime=" + createTime + ", totalPrice=" + totalPrice + ", status="
				+ status + ", userId=" + userId + "]";
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, Date createTime, BigDecimal totalPrice, Integer status, Integer userId) {
		super();
		this.orderId = orderId;
		this.createTime = createTime;
		this.totalPrice = totalPrice;
		this.status = status;
		this.userId = userId;
	}
	
}
