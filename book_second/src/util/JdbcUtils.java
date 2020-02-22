package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtils {
	
	static DruidDataSource dataSource;
	static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	static {
		try {
			InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties pros = new Properties();
			pros.load(is);
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = threadLocal.get();
		if(conn == null) {
			try {
				conn = dataSource.getConnection();
				threadLocal.set(conn);
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
		// void commitAndClose()
	public static void commitAndClose() {
		Connection conn = threadLocal.get();
		if(conn != null) {
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		threadLocal.remove();
	}
		// void rollbackAndClose()
	public static void rollbackAndClose() {
		Connection conn = threadLocal.get();
		if(conn != null) {
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		threadLocal.remove();
	}
}
