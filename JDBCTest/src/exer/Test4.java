package exer;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import exer1.JDBCUtil;


public class Test4 {
	// 通用的针对于不同表的查询:返回一个对象 (version 1.0)
	public <T> T getInstance(Class<T> clazz, String sql, Object... args) throws Exception {

		// 1.获取数据库连接
		Connection conn = JDBCUtil.getConn();

		// 2.预编译sql语句，得到PreparedStatement对象
		PreparedStatement ps = conn.prepareStatement(sql);

		// 3.填充占位符
		for (int i = 0; i < args.length; i++) {
			ps.setObject(i + 1, args[i]);
		}

		// 4.执行executeQuery(),得到结果集：ResultSet
		ResultSet rs = ps.executeQuery();

		// 5.得到结果集的元数据：ResultSetMetaData
		ResultSetMetaData rsmd = rs.getMetaData();

		// 6.1通过ResultSetMetaData得到columnCount,columnLabel；通过ResultSet得到列值
		int columnCount = rsmd.getColumnCount();
		if (rs.next()) {
			T t = clazz.newInstance();
			for (int i = 0; i < columnCount; i++) {// 遍历每一个列

				// 获取列值
				Object columnVal = rs.getObject(i + 1);
				// 获取列的别名:列的别名，使用类的属性名充当
				String columnLabel = rsmd.getColumnLabel(i + 1);
				// 6.2使用反射，给对象的相应属性赋值
				Field field = clazz.getDeclaredField(columnLabel);
				field.setAccessible(true);
				field.set(t, columnVal);
			}
			return t;
		}
		// 7.关闭资源
		JDBCUtil.closeResource(conn, ps, rs);
		return null;
	}
}