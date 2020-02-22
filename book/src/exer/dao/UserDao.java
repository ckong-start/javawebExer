package exer.dao;

import exer.pojo.User;

public interface UserDao {
	/**
	 * 根据用户名和密码来查询用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	public User queryUserByUsernameAndPassword(String username, String password);
	
	/**
	 * 根据用户名来查
	 * @param username
	 */
	public User queryUserByUsername(String username);
	
	/**
	 * 保存用户信息到数据库
	 * @param user
	 * @return
	 */
	public int saveUser(User user);
}
