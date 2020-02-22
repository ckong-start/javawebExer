package exer3;

import java.util.List;

import exer2.User;

public class UserDAO2 extends BaseDAO2 {

	public int saveUser(User user) {
		
		String sql = "insert into user (username,password,money) values(?,?,?)";
		return updateDB(sql,user.getUsername(),user.getPassword(),user.getMoney());
		
	}
	
	public int updateUser(User user) {
		String sql = "update user set name = ?, password = ?,money = ? where id = ?";
		return updateDB(sql, user.getUsername(),user.getPassword(),user.getMoney(),user.getId());
	}
	
	public int deleteUserById(Integer id) {
		String sql = "delete from user where id = ?";
		return updateDB(sql, id);
		
	}
	
	public User queryUserById(Integer id) {
		String sql = "select * from user where id = ?";
		return queryOne(User.class,sql, id);
	}
	
	public List<User> queryUsers(){
		String sql = "select * from user";
		return queryAll(User.class,sql);
	}
}
