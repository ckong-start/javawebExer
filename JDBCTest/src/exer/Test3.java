package exer;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import org.junit.Test;

import exer1.JDBCUtil;



public class Test3 {
	
	@Test
	public void test() throws Exception {
		Connection conn = JDBCUtil.getConn();
		/*String sql = "select id,name,birth from customers where id = ?";
		Customer cust = queryForCustomer(sql, 4);
		System.out.println(cust);*/
		String sql = "select id,name,email,birth from customers where id = ?";
		List<Customer> list = JDBCUtil.queryForT(conn,Customer.class, sql, 4);
		list.forEach(System.out::println);
	}
	
	public static void queryTest(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select * from customers where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 2);
			rs = ps.executeQuery();
			Customer cust= null;
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				Date date = rs.getDate(4);
				cust = new Customer(id, name, email, date);
			}
			System.out.println(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtil.closeResource(conn, ps, rs);
		}
	}
	
	public static Customer queryForCustomer(String sql, Object...args) throws Exception {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i = 0;i < args.length;i++) {
			ps.setObject(i + 1, args[i]);
		}
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		
		if(rs.next()) {
			Customer cust = new Customer();
			for(int i = 0;i < columnCount;i++) {
				Object columValue = rs.getObject(i + 1);
				String columnLabel = rsmd.getColumnLabel(i + 1);
				Field field = Customer.class.getDeclaredField(columnLabel);
				field.setAccessible(true);
				field.set(cust, columValue);
			}
			return cust;
		}
		JDBCUtil.closeResource(conn, ps, rs);
		
		return null;
	}
	
	
}
