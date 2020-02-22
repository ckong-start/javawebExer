package exer3;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import exer1.JDBCUtil;
/**
 * 借助DBUtils的CRUD
 * @author CKong
 *
 */
public abstract class BaseDAO2 {
	
	QueryRunner runner = new QueryRunner();
	
	//使用DBUtils的增删改
	public int updateDB(String sql,Object...args){
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			return runner.update(conn, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(null, null);
		}
		return -1;
	}
	
	//使用DBUtils的查询
	public <T> List<T> queryAll(Class<T> clazz,String sql){
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			return runner.query(conn, sql, new BeanListHandler<T>(clazz));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, null);
		}
		return null;
	}
	//查询一条记录
	public <T> T queryOne(Class<T> clazz,String sql,Object...args){
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			return runner.query(conn, sql, new BeanHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, null);
		}
		return null;
	}
}
