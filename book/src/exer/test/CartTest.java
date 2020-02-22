package exer.test;

import java.math.BigDecimal;

import org.junit.Test;

import exer.pojo.Cart;
import exer.pojo.CartItem;

public class CartTest {

	@Test
	public void testAddItem() {
		Cart cart = new Cart();
		
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		
		System.out.println( cart );

	}

	@Test
	public void testDeleteItem() {
		Cart cart = new Cart();
		
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		
		cart.deleteItem(1);
		System.out.println( cart );
	}

	@Test
	public void testClear() {
		Cart cart = new Cart();
		
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		
		cart.clear();
		System.out.println( cart );
	}

	@Test
	public void testUpdateCount() {
		Cart cart = new Cart();
		
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(10000), new BigDecimal(10000)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		cart.addItem(new CartItem(2, "小苹果", 1, new BigDecimal(10), new BigDecimal(10)));
		
		cart.updateCount(1, 1);
		System.out.println(cart);
	}

}
