package exer.service.impl;

import exer.dao.UserDao;
import exer.dao.impl.UserDaoImpl;
import exer.pojo.User;
import exer.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userdao = new UserDaoImpl();
	@Override
	public void registUser(User user) {
		userdao.saveUser(user);
	}

	@Override
	public User login(User user) {
		return userdao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public boolean existsUsername(String username) {
		 User user = userdao.queryUserByUsername(username);
		 if(user == null) {
			 return false;
		 }else {
			 return true;
		 }
	}

}
