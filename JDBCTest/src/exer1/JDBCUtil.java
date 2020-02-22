package exer1;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {
	
	/**
	 * 获取连接的操作
	 * @return Connection
	 * @throws Exception
	 */
	private static Properties pros;
	static {
		try {
			pros = new Properties();
			pros.load(ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws Exception{
		
		String url = pros.getProperty("url");
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String driverClassName = pros.getProperty("driverClass");
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	/**
	 * 获取druid连接的操作
	 * @return
	 * @throws Exception
	 */
	private static DataSource source1;
	static {
		try {
			Properties pros = new Properties();
			pros.load(new FileInputStream("druid.properties"));
			source1 = DruidDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn1() throws Exception{
		Connection conn = source1.getConnection();
		return conn;
	}
	/**
	 * 修改数据的操作,考虑到事务，暂时不关闭conn的连接
	 * @param sql
	 * @param args
	 */
	public static int update(Connection conn,String sql, Object ...args){
		
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			for(int i = 0; i < args.length; i++){
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeResource(null, ps);
		}
		return 0;
	}
	
	/**
	 * 通用查询一条信息操作
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 * @throws Exception
	 */
	/*public static <T> T queryForT(Class<T> clazz, String sql, Object...args) throws Exception {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i = 0;i < args.length;i++) {
			ps.setObject(i + 1, args[i]);
		}
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		
		if(rs.next()) {
			T t = clazz.newInstance();
			for(int i = 0;i < columnCount;i++) {
				Object columValue = rs.getObject(i + 1);
				String columnLabel = rsmd.getColumnLabel(i + 1);
				Field field = clazz.getDeclaredField(columnLabel);
				field.setAccessible(true);
				field.set(t, columValue);
			}
			return t;
		}
		JDBCUtil.closeResource(conn, ps, rs);
		
		return null;
	}*/
	/**
	 * 查询多条记录的操作
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> queryForT(Connection conn, Class<T> clazz, String sql, Object...args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement(sql);
			for(int i = 0;i < args.length;i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			ArrayList<T> list = new ArrayList<T>();
			while(rs.next()) {
				T t = clazz.newInstance();
				for(int i = 0;i < columnCount;i++) {
					Object columValue = rs.getObject(i + 1);
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columValue);
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(null, ps, rs);
		}
		return null;
	}
	/**
	 * 关闭资源的操作
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn, Statement ps) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 关闭资源2
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeResource(Connection conn,Statement ps,ResultSet rs){
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
