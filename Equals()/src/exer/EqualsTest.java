package exer;
/*
 * 手动重写object类中的equals()方法。
 * 使其功能为比较两个对象的“实体内容”，而不是地址值。
 */

public class EqualsTest {
	public static void main(String[] args) {
		Order o1 = new Order(1001, "AAA");
		Order o2 = new Order(1002, "AAA");
		boolean b1 = o1.equals(o2);
		Order o3 = new Order(1002, "AAA");
		boolean b2 = o3.equals(o2);
		System.out.println(b1 + "\n" + b2);
		
	}
}

class Order {
	private int orderId;
	private String orderName;

	public Order() {
		super();
	}

	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj instanceof Order){
			Order order = (Order)obj;
			return this.orderId == order.orderId && 
					this.orderName.equals(order.orderName);
		}
		return false; 
	}

}