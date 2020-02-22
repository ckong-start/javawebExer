package exer1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class Test2 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into user_table values(?,?,?)";
			QueryRunner runner = new QueryRunner();
			int i = runner.update(conn, sql, "FF", 121221, 2500);
			if (i > 0)
				System.out.println("添加成功");
		} catch (Exception e) {
			JDBCUtil.closeResource(conn, null);
		}
	}
	@Test
	public void queryForOne() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select * from user_table";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Object user = rs.getObject(1);
				Object name = rs.getObject(2);
				Object balance = rs.getObject(3);
				System.out.println(user + "-" + name + "-" + balance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, ps, rs);
		}
	}
	/**
	 * 模拟事务的操作
	 */
	@Test
	public void testConn(){
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn1();
			System.out.println(conn.getAutoCommit());
			conn.setAutoCommit(false);
			String sql = "update user_table set balance = balance - 100 where user = ?";
			update(conn, sql, "AA");
			System.out.println(10 / 0);
			sql = "update user_table set balance = balance + 100 where user = ?";
			update(conn, sql, "BB");
			System.out.println("转账成功");
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeResource(conn, null);
		}
		
	}
	/**
	 * 考虑事务后的update操作
	 * @param conn
	 * @param sql
	 * @param args
	 * @return
	 */
	private int update(Connection conn,String sql,Object...args) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0;i < args.length;i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeResource(null, ps);
		return 0;
	}
	/**
	 * 使用DBUtils的查询操作
	 */
	@Test
	public void testQuery() {
		Connection conn = null;
		try {
			String sql = "select * from customers";
			conn = JDBCUtil.getConn1();
			QueryRunner runner = new QueryRunner();
	
			BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
			List<Customer> list = runner.query(conn, sql, handler);
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, null);
		}
	}
	/**
	 * 使用ps处理Blob类型的操作
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		Connection conn = JDBCUtil.getConn1();
		String sql = "update customers set photo = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setBlob(1, new FileInputStream("src//girl.jpg"));
		ps.setObject(2, 19);
		ps.execute();
		JDBCUtil.closeResource(conn, ps);
		/*QueryRunner runner = new QueryRunner();
		runner.update(conn, sql, 4);*/
	}
}
