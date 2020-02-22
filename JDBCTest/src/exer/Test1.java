package exer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class Test1 {
	@Test
	public void test1() throws Exception{
		Connection conn = getConnection1();
		Statement state = conn.createStatement();
		String sql = "insert into test values (null,'王五',1000)";
		int i = state.executeUpdate(sql);
		System.out.println(i > 0 ? "修改成功" : "修改失败");
		state.close();
		conn.close();
	}
	
	@Test
	public void test3() throws Exception{
		Connection conn = getConnection2();
		Statement state = conn.createStatement();
		String sql = "select * from test";
		ResultSet rs = state.executeQuery(sql);
		while(rs.next()){
			Object name = rs.getObject(1);
			Object balance = rs.getObject(2);
			System.out.println(name + ":" + balance);
		}
		rs.close();
		state.close();
		conn.close();
	}
	
	public Connection getConnection1() throws ClassNotFoundException, SQLException{
//		Driver driver = new com.mysql.jdbc.Driver();
		String driverClass = "com.mysql.jdbc.Driver";
		Class.forName(driverClass);
		String url = "jdbc:mysql://localhost:3306/db1?rewriteBatchedStatements=true";
//		String url = "jdbc:mysql://localhost:3306/db1";
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	@Test
	public static Connection getConnection2(){
		
		Properties pros = new Properties();
		Connection conn = null;
		try {
			pros.load(Test1.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			String url = pros.getProperty("url");
			String user = pros.getProperty("user");
			String password = pros.getProperty("password");
			String driverClass = pros.getProperty("driverClass");
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
