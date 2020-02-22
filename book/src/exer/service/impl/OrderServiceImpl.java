package exer.service.impl;

import java.util.Date;

import exer.dao.BookDao;
import exer.dao.OrderDao;
import exer.dao.OrderItemDao;
import exer.dao.impl.BookDaoImpl;
import exer.dao.impl.OrderDaoImpl;
import exer.dao.impl.OrderItemDaoImpl;
import exer.pojo.Book;
import exer.pojo.Cart;
import exer.pojo.CartItem;
import exer.pojo.Order;
import exer.pojo.OrderItem;
import exer.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao = new OrderDaoImpl();
	OrderItemDao orderItemDao = new OrderItemDaoImpl();
	BookDao bookDao = new BookDaoImpl();

	@Override
	public String createOrder(Integer userId, Cart cart) {
		//订单号要求唯一
		String orderId = System.currentTimeMillis() + "" + userId;
		//保存订单
		Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
		orderDao.saveOrder(order);
		//模拟错误
		//int i = 12 / 0;
		//保存订单项
		for (CartItem item : cart.getItems().values()) {
			//将购物车商品项，转换为订单项，并保存
			orderItemDao.saveOrderItem(
					new OrderItem(null, item.getName(), item.getPrice(), item.getTotalPrice(), item.getCount(), order.getOrderId()));
			//查询要购买的图书信息
			Book book = bookDao.queryBookById(item.getId());
			//修改销量
			book.setSales(book.getSales() + 1);
			//修改库存
			book.setStock(book.getStock() - 1);
			bookDao.updateBook(book);
		}
		//清空购物车
		cart.clear();
		return orderId;
	}

}
