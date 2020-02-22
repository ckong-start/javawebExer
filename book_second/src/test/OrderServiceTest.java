package test;

import static org.junit.Assert.*;

import org.junit.Test;

import service.OrderService;
import service.impl.OrderServiceImpl;

public class OrderServiceTest {

	@Test
	public void testQueryOrdersByUserId() {
		OrderService orderService = new OrderServiceImpl();
		orderService.queryOrdersByUserId(2).forEach(System.out::println);
	}

}
