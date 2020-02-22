package exer.service;

import exer.pojo.User;

public interface UserService {
	/**
	 * 用户注册
	 * @param user
	 */
	public void registUser(User user);
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 检查用户名是否存在
	 * @param username
	 * @return 返回true表示用户名存在
	 * 			返回false表示用户名可用
	 */
	public boolean existsUsername(String username);
}
