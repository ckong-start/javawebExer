package dao;

import pojo.User;

public interface UserDao {
	int saveUer(User user);
	User queryUserByUsername(String username);
	User queryUserByUsernameAndPassword(String username, String password);
}
