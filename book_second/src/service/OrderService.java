package service;

import java.util.List;

import pojo.Cart;
import pojo.Order;

public interface OrderService {

	String createOrder(Cart cart, Integer id);
	List<Order> queryOrdersByUserId(Integer id);
}
