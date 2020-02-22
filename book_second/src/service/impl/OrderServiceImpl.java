package service.impl;

import java.util.Date;
import java.util.List;

import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import pojo.Cart;
import pojo.CartItem;
import pojo.Order;
import pojo.OrderItem;
import service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao = new OrderDaoImpl();
	OrderItemDao orderItemDao = new OrderItemDaoImpl();

	@Override
	public String createOrder(Cart cart, Integer userId) {
		// 订单号唯一
		String orderId = System.currentTimeMillis() + "" + userId;
		// 保存订单
		Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
		orderDao.saveOrder(order);
		// 保存订单号
		for (CartItem item : cart.getItems()) {
			OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(),
					item.getTotalPrice(), orderId);
			orderItemDao.saveOrderItem(orderItem);
		}
		cart.clear();
		return orderId;
	}

	@Override
	public List<Order> queryOrdersByUserId(Integer userId) {
		return orderDao.queryOrdersByUserId(userId);
	}

}
