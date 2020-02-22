package exer.test;

import java.math.BigDecimal;

import org.junit.Test;

import exer.pojo.Cart;
import exer.pojo.CartItem;
import exer.service.OrderService;
import exer.service.impl.OrderServiceImpl;

public class OrderServiceImplTest {

	@Test
	public void testCreateOrder() {
		Cart cart = new Cart();
		
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		
		OrderService orderService = new OrderServiceImpl();
		
		orderService.createOrder(1, cart);

	}

}
