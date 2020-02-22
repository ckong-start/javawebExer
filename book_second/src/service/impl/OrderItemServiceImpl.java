package service.impl;

import java.util.List;


import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import pojo.OrderItem;
import service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	@Override
	public List<OrderItem> queryOrderItems(String orderId) {
		return orderItemDao.queryOrderItemsByOrderId(orderId);
	
	}

}
