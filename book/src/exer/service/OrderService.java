package exer.service;

import exer.pojo.Cart;

public interface OrderService {
	/**
	 * 生成订单
	 */
	public String createOrder(Integer userId, Cart cart);
}
