package exer.test;

import java.math.BigDecimal;

import org.junit.Test;

import exer.dao.OrderItemDao;
import exer.dao.impl.OrderItemDaoImpl;
import exer.pojo.OrderItem;

public class OrderItemDaoTest {

	@Test
	public void testSaveOrderItem() {
		OrderItemDao orderItemDao = new OrderItemDaoImpl();
		orderItemDao.saveOrderItem(new OrderItem(null, "母猪产后护理", new BigDecimal(
				10000), new BigDecimal(10000), 1, "12121212"));
		orderItemDao.saveOrderItem(new OrderItem(null, "国哥产后护理", new BigDecimal(
				20000), new BigDecimal(20000), 1, "12121212"));

	}

}
