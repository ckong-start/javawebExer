package exer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Test2 {
	
	Connection conn = Test1.getConnection2();
	@Test
	public void test() throws Exception{//添加表数据
		
		String sql = "insert into test values (null,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 1; i <= 10000; i++) {

			ps.setObject(1, "李四" + i);
			ps.setObject(2, 22);
//			ps.executeUpdate();
			ps.addBatch();
			if(i % 500 == 0){
				ps.executeBatch();
				ps.clearBatch();
			}
		}
		ps.close();
		conn.close();
	}
	@Test
	public void test11() throws Exception{//删除表中记录
	
		String sql = "truncate table test";
		PreparedStatement ps = conn.prepareStatement(sql);
		int i = ps.executeUpdate();
		System.out.println(i);
		ps.close();
		conn.close();
	}
	
	@Test
	public void test111() throws Exception{//查询表记录
		System.out.println("id-name-age");
	
		String sql = "select * from test";
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery(sql);
		while(result.next()){
			Object id = result.getObject(1);
			Object name = result.getObject(2);
			Object age = result.getObject(3);
			System.out.println(id + "-" + name + "-" + age);
		}
	}
}
