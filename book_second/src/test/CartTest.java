package test;

import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;

import pojo.Cart;
import pojo.CartItem;

public class CartTest {
	Cart cart = new Cart();
	@Test
	public void testAddItem() {
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(2, "笔记本", 1, new BigDecimal(8000), new BigDecimal(8000)));
		System.out.println(cart);
	}

	@Test
	public void testDeleteItem() {
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(2, "笔记本", 1, new BigDecimal(8000), new BigDecimal(8000)));
		
		System.out.println(cart);
		cart.deleteItem(3);

		System.out.println(cart);
	}

	@Test
	public void testClear() {
		
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(2, "笔记本", 1, new BigDecimal(8000), new BigDecimal(8000)));
		
		System.out.println(cart);
		
		cart.clear();
		
		System.out.println( cart );  

	}

	@Test
	public void testUpdateCount() {
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(2, "笔记本", 1, new BigDecimal(8000), new BigDecimal(8000)));
		
		System.out.println(cart);
		
		cart.updateCount(1, 10);
		cart.updateCount(2, 10);
		
		System.out.println( cart );  

	}

	@Test
	public void testGetItems() {
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(2, "笔记本", 1, new BigDecimal(8000), new BigDecimal(8000)));
		cart.getItems().forEach(System.out::println);
	}

	@Test
	public void testGetTotalCount() {
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(2, "笔记本", 1, new BigDecimal(8000), new BigDecimal(8000)));
		System.out.println(cart.getTotalCount());
	}

	@Test
	public void testGetTotalPrice() {
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(1, "内衣", 1, new BigDecimal(20), new BigDecimal(20)));
		cart.addItem(new CartItem(2, "笔记本", 1, new BigDecimal(8000), new BigDecimal(8000)));
		System.out.println(cart.getTotalPrice());
	}

}
