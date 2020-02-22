package test;

import org.junit.Test;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.JdbcUtils;

public class UserServiceTest {
	UserService userService = new UserServiceImpl();
	
	@Test
	public void testLogin() {
		User user = userService.login(new User(null, "qwe1234", "123456", null));
		if(user == null) {
			System.out.println("登录失败");
		}else {
			System.out.println("登录成功");
		}
	}

	@Test
	public void testRegistUser() {
		userService.registUser(new User(null, "qwe1234", "123456", "qwe1234@qq.com"));
		JdbcUtils.commitAndClose();
	}

	@Test
	public void testExistsUsername() {
		boolean result = userService.existsUsername("qwe1234");
		if(result) {
			System.out.println("用户名存在");
		}else {
			System.out.println("用户名可用");
		}
	}

}
