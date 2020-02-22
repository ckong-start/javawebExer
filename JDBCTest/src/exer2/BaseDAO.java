package exer2;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import exer1.JDBCUtil;
/**
 * 手写的CRUD
 * @author CKong
 *
 */
public abstract class BaseDAO<T> {
	private Class<T> clazz = null;
	{
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) genericSuperclass;
		Type[] actualTypeArguments = paramType.getActualTypeArguments();
		clazz = (Class<T>) actualTypeArguments[0];
	}
	
	//增删改
	public int update(Connection conn,String sql,Object...args){
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0;i < args.length;i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(null, ps);
		}
		return -1;
	}
	//查询一条记录
	public T queryOne(Connection conn,String sql,Object...args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			if(rs.next()) {
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					Object value = rs.getObject(i + 1);
					String name = rsmd.getColumnLabel(i + 1);
					Field field = clazz.getDeclaredField(name);
					field.setAccessible(true);
					field.set(t, value);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtil.closeResource(null, ps, rs);
		}
		return null;
	}

	//查询所有
	public List<T> queryAll(Connection conn,String sql,Object...args){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			ArrayList<T> list = new ArrayList<>();
			while(rs.next()) {
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					Object columnValue = rs.getObject(i + 1);
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, ps, rs);
		}
		return null;
	}
	//查询特殊值
	public <E> E getValue(Connection conn,String sql,Object...args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			if(rs.next()) {
				return (E) rs.getObject(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCUtil.closeResource(null, ps, rs);
		}
		return null;
	}
}
