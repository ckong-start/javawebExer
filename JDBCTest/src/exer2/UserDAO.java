package exer2;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import exer1.JDBCUtil;

public class UserDAO extends BaseDAO<User>{

	
	public int saveUser(Connection conn,User user) {
		String sql = "insert into user_table (user,password,balance) values(?,?,?)";
		return update(conn,sql,user.getUsername(),user.getPassword(),user.getMoney());
		
	}
	
	public int updateUser(Connection conn,User user) {
		String sql = "update user_table set user = ?, password = ?,balance = ? where id = ?";
		return update(conn, sql, user.getUsername(),user.getPassword(),user.getMoney(),user.getId());
	}
	
	public int deleteUserById(Connection conn,Integer id) {
		String sql = "delete from user_table where id = ?";
		return update(conn, sql, id);
	}
	
	public User queryUserById(Connection conn,Integer id) {
		String sql = "select id,user username,password,balance money from user_table where id = ?";
		return queryOne(conn, sql, id);
	}
	
	public List<User> queryUsers(Connection conn){
		String sql = "select id,user username,password,balance money from user_table";
		return queryAll(conn, sql);
	}
}
