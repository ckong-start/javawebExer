package dao;

import java.util.List;

import pojo.OrderItem;

public interface OrderItemDao {
	int saveOrderItem(OrderItem orderItem);
	List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
