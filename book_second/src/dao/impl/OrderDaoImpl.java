package dao.impl;

import java.util.List;

import dao.OrderDao;
import pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		String sql = "insert into t_order (`order_id`, `create_time`, `total_price`, `status`, `user_id`)"
				+ "values(?,?,?,?,?)";
		return update(sql, order.getOrderId(), order.getCreateDate(), order.getPrice(), order.getStatus(),
				order.getUserId());

	}

	@Override
	public List<Order> queryOrdersByUserId(Integer userId) {
		String sql = "select `order_id` orderId, `create_time` createDate, `total_price` price, `status` from t_order where user_id = ?";
		return queryForList(Order.class, sql, userId);
	}

}
