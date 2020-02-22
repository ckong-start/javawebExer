package exer.dao.impl;

import exer.dao.OrderDao;
import exer.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		String sql = "insert into t_order(`order_id`,`create_time`,`total_price`,`status`,`user_id`) values(?,?,?,?,?)";
		return update(sql, order.getOrderId(), order.getCreateTime(), order.getTotalPrice(), order.getStatus(), order.getUserId());
	}

}
