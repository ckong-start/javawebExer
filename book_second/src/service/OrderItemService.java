package service;

import java.util.List;

import pojo.OrderItem;

public interface OrderItemService {

	List<OrderItem> queryOrderItems(String orderId);
}
