package exer.test;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import exer.pojo.User;
import exer.service.UserService;
import exer.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	private UserService userService = new UserServiceImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testRegistUser() {
		userService.registUser(new User(null, "abc", "abc123", "abc@163.com"));
	}

	@Test
	public void testLogin() {
		User login = userService.login(new User(null, "abc1", "abc123", null));
		if(login == null) {
			System.out.println("用户名或密码错误，登录失败");
		}else {
			System.out.println("登录成功");
		}
	}

	@Test
	public void testExistsUsername() {
		boolean b = userService.existsUsername("abc");
		if(b) {
			System.out.println("用户名已存在");
		}else {
			System.out.println("用户名可用");
		}
	}

}
