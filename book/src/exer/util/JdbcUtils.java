package exer.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtils {
	private static DruidDataSource dataSource;
	// 使用ThreadLocal来为每个线程管理Connection连接对象
	static ThreadLocal<Connection> conns = new ThreadLocal<>();
	
	static {
		try {
			Properties pros = new Properties();
			// 读取 jdbc.properties属性配置，并加载到Properties集合中
			pros.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			// 根据连接信息，创建数据库连接池
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
//			System.out.println(dataSource.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*public static void main(String[] args) {
		
	}*/
	
	/**
	 * 从数据库连接池中获取连接<br/>
	 * 考虑事务
	 */
	public static Connection getConnection() {
		// 先从threadLocal中获取连接，确保是同一个
		Connection conn = conns.get();
		// 如果是第一次获取，则里面没有连接对象，就可以从连接池中获取连接
		if(conn == null) {
			try {
				conn = dataSource.getConnection();
				// 保存到ThreadLocal中，方便当前线程后面使用。
				conns.set(conn);
				// 设置为手动管理事务
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
/*		
 		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;*/
	}
	/**
	 * 提交和关闭连接
	 */
	public static void commitAndClose() {
		Connection conn = conns.get();
		if(conn != null) {
			try {
				// 提交并关闭连接
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 一定要移除当前线程的关联。否则就会报错。因为tomcat服务器底层使用了线程池
		conns.remove();
	}
	/**
	 * 回滚和关闭连接
	 */
	public static void rollbackAndClose() {
		Connection conn = conns.get();
		if(conn != null) {
			try {
				// 回滚并关闭连接
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//道理同上
		conns.remove();
	}
	/*
	 * 关闭connection连接
	 * @param conn
	
	public static void closeSource(Connection conn) {
		if(conn != null) {
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	} */
}
