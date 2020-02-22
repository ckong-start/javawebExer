package exer.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import exer.dao.OrderDao;
import exer.dao.impl.OrderDaoImpl;
import exer.pojo.Order;

public class OrderDaoTest {

	@Test
	public void testSaveOrder() {
		OrderDao orderDao = new OrderDaoImpl();
		
		orderDao.saveOrder(new Order("12121212", new Date(), new BigDecimal(121212), 1, 1));

	}

}
