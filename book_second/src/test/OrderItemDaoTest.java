package test;

import org.junit.Test;

import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;

public class OrderItemDaoTest {
	private OrderItemDao orderItemDao  = new OrderItemDaoImpl();
	@Test
	public void testQueryOrderItemsByOrderId() {
		orderItemDao.queryOrderItemsByOrderId("15773476508822").forEach(System.out::println);
	}

}
