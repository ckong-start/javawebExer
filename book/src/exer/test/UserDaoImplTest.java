package exer.test;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import exer.dao.UserDao;
import exer.dao.impl.UserDaoImpl;
import exer.pojo.User;

public class UserDaoImplTest {

	private UserDao userdao = new UserDaoImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testQueryUserByUsernameAndPassword() {
		User user1 = userdao.queryUserByUsernameAndPassword("admin", "admin");
		User user2 = userdao.queryUserByUsernameAndPassword("zxc", "123456");
		System.out.println(user1);
		System.out.println(user2);
	}

	@Test
	public void testQueryUserByUsername() {
		User user = userdao.queryUserByUsername("zxc");
		if(user == null) {
			System.out.println("用户名可以使用");
		}else {
			System.out.println("用户名已存在");
		}
	}

	@Test
	public void testSaveUser() {
		System.out.println(userdao.saveUser(new User(null, "zxc", "123456", "zxc@168.com")));
	}

}
