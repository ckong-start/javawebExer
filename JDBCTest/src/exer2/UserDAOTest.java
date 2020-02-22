package exer2;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import exer1.JDBCUtil;

public class UserDAOTest {
	private UserDAO userDao = new UserDAO();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSaveUser() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			User user = new User(null,"Tom","123456",2005);
			userDao.saveUser(conn, user);
			System.out.println("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, null);
		}
		
	}

	@Test
	public void testUpdateUser() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			User user = new User(7,"FF","asdfg",4000);
			userDao.updateUser(conn, user);
			System.out.println("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	@Test
	public void testDeleteUserById() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			userDao.deleteUserById(conn, 9);
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	@Test
	public void testQueryUserById() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			User user = userDao.queryUserById(conn, 7);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	@Test
	public void testQueryUsers() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			List<User> list = userDao.queryUsers(conn);
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

}
