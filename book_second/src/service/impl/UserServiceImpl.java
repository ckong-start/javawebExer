package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public User login(User user) {
		return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public void registUser(User user) {
		userDao.saveUer(user);
	}

	@Override
	public boolean existsUsername(String username) {
		User user = userDao.queryUserByUsername(username);
		if(user == null) {
			return false;
		}
		return true;
	}

}
