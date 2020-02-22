package dao;

import java.util.List;

import pojo.Order;

public interface OrderDao {
	int saveOrder(Order order);

	List<Order> queryOrdersByUserId(Integer userId);
}
