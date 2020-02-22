package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import util.JdbcUtils;

public abstract class BaseDao {
	QueryRunner runner = new QueryRunner();
	
	public int update(String sql, Object...args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return runner.update(conn, sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public <T> T queryForOne(Class<T> type, String sql, Object...args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return runner.query(conn, sql, new BeanHandler<T>(type), args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public <T> List<T> queryForList(Class<T> type, String sql, Object...args){
		Connection conn = JdbcUtils.getConnection();
		try {
			return runner.query(conn, sql, new BeanListHandler<T>(type), args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Object queryForSimpleValue(String sql, Object...args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return runner.query(conn, sql, new ScalarHandler(), args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
