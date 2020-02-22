package test;

import static org.junit.Assert.fail;

import org.junit.Test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import util.JdbcUtils;

public class UserDaoTest {
	
	UserDao userDao = new UserDaoImpl();
	@Test
	public void testSaveUer() {
		int i = userDao.saveUer(new User(null, "qwe1234", "123456", "qwe1234@qq.com"));
		JdbcUtils.commitAndClose();
		System.out.println(i);
	}

	@Test
	public void testQueryUserByUsername() {
		User user = userDao.queryUserByUsername("qwe1234");
		System.out.println(user);
	}

	@Test
	public void testQueryUserByUsernameAndPassword() {
		User user = userDao.queryUserByUsernameAndPassword("qwe123", "123456");
		System.out.println(user);
	}

}
