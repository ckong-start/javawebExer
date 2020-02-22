package service;

import pojo.User;

public interface UserService {
	User login(User user);
	void registUser(User user);
	boolean existsUsername(String username);
}
