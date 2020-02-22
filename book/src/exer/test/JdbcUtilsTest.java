package exer.test;


import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import exer.util.JdbcUtils;

public class JdbcUtilsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		for (int i = 0; i < 100; i++) {
			Connection conn = JdbcUtils.getConnection();
			System.out.println(conn);

		}
	}

}
