package test;


import org.junit.Test;

import service.OrderItemService;
import service.impl.OrderItemServiceImpl;

public class OrderItemServiceTest {
	private OrderItemService orderItemService = new OrderItemServiceImpl();
	@Test
	public void testGetOrderItems() {
		orderItemService.queryOrderItems("15773476508822").forEach(System.out::println);
	}

}
