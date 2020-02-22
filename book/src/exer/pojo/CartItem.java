package exer.pojo;

import java.math.BigDecimal;

public class CartItem {
	private Integer id;//商品编号
	private String name;//商品名称
	private Integer count;//商品数量
	private BigDecimal price;//商品价格
	private BigDecimal totalPrice;//商品总价格
	
	
	public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", count=" + count + ", price=" + price + ", totalPrice="
				+ totalPrice + "]";
	}
	
	
}
