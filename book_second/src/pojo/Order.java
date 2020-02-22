package pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	// 订单号
	private String orderId;
	// 生成订单的时间
	private Date createDate;
	// 订单的金额
	private BigDecimal price;
	// 订单状态 0未发货，1已发货，2已签收
	private Integer status;
	// 用户编号
	private Integer userId;
	public Order() {
		super();
	}
	public Order(String orderId, Date createDate, BigDecimal price, Integer status, Integer userId) {
		super();
		this.orderId = orderId;
		this.createDate = createDate;
		this.price = price;
		this.status = status;
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
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
		return "Order [orderId=" + orderId + ", createDate=" + createDate + ", price=" + price + ", status=" + status
				+ ", userId=" + userId + "]";
	}
	
}
