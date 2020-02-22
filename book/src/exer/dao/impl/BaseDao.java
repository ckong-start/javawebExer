package exer.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import exer.util.JdbcUtils;

public class BaseDao {

	private QueryRunner runner = new QueryRunner();
	/**
	 * 执行insert、update、delete的sql语句。
	 * @param sql
	 * @param args
	 * @return
	 */
	public int update(String sql, Object...args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return runner.update(conn, sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询一条结果
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> T queryForOne(Class<T> clazz, String sql, Object...args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return runner.query(conn, sql, new BeanHandler<T>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询多条结果
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T> queryForList(Class<T> clazz, String sql, Object...args){
		Connection conn = JdbcUtils.getConnection();
		try {
			return runner.query(conn, sql, new BeanListHandler<T>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询返回单个列值的情况
	 * @param sql
	 * @param args
	 * @return
	 */
	public Object queryForSingleValue(String sql, Object...args) {
		Connection conn = JdbcUtils.getConnection();
		try {
			return runner.query(conn, sql, new ScalarHandler(), args);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
