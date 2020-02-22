package exer1;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void insertTest() throws Exception{
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into customers (name, email, birth) values (?,?,?)";
		JDBCUtil.update(conn, sql, "许嵩","xusong@126.com","1990-01-01");
		JDBCUtil.closeResource(conn, null);
	}
	@Test
	public void studentTest() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入四级/六级：");
		int type = sc.nextInt();
		System.out.print("请输入身份证号：");
		String IDCard = sc.next();
		System.out.print("请输入准考证号：");
		String examCard = sc.next();
		System.out.print("请输入学生姓名：");
		String name = sc.next();
		System.out.print("请输入区域：");
		String location = sc.next();
		System.out.print("请输入成绩：");
		int grade = sc.nextInt();
		
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into examstudent (Type,IDCard,ExamCard,StudentName,Location,Grade) values (?,?,?,?,?,?)";
		int i = JDBCUtil.update(conn, sql, type,IDCard,examCard,name,location,grade);
		if(i > 0)
			System.out.println("信息录入成功！");
		else
			System.out.println("信息录入失败。");
		sc.close();
	}
	@Test
	public void queryTest() throws Exception {
		Connection conn = JDBCUtil.getConn();
		Scanner sc = new Scanner(System.in);
		System.out.println("请选择您要输入的类型：");
		System.out.println("a.准考证号");
		System.out.println("b.身份证号");
		String type = sc.next();
		if("a".equalsIgnoreCase(type)) {
			System.out.print("请输入准考证号：");
			String examCard = sc.next();
			String sql = "select FlowID flowID, Type type, IDCard, ExamCard examCard, StudentName name, Location location, Grade grade from examstudent where ExamCard = ?";
			List<ExamStudent> list = JDBCUtil.queryForT(conn, ExamStudent.class,sql, examCard);
			if(list.size() == 0)
				System.out.println("查无此人！请重新进入程序");
			else
				System.out.println(list.get(0).toString());
		}else if("b".equalsIgnoreCase(type)) {
			System.out.print("请输入身份证号：");
			String IDCard = sc.next();
			String sql = "select FlowID flowID, Type type, IDCard, ExamCard examCard, StudentName name, Location location, Grade grade from examstudent where IDCard = ?";
			JDBCUtil.queryForT(conn, ExamStudent.class, sql, IDCard);
			List<ExamStudent> list = JDBCUtil.queryForT(conn, ExamStudent.class, sql, IDCard);
			if(list.size() == 0)
				System.out.println("查无此人！请重新进入程序");
			else
				System.out.println(list.get(0).toString());
		}else {
			System.out.println("您的输入有误！请重新进入程序。");
		}
		sc.close();
	}
	@Test
	public void testGrade() throws Exception {
		Connection conn = JDBCUtil.getConn();
		String sql = "select FlowID flowID, Type type, IDCard, ExamCard examCard, StudentName name, Location location, Grade grade from examstudent where Grade > ?";
		List<ExamStudent> list = JDBCUtil.queryForT(conn, ExamStudent.class, sql, 60);
		list.forEach(System.out :: println);
	}
	@Test
	public void testDelete() throws Exception {
		Connection conn = JDBCUtil.getConn();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入考试号：");
		String examCard = sc.next();
		String sql = "delete from examstudent where ExamCard = ?";
		int i = JDBCUtil.update(conn, sql, examCard);
		if(i > 0)
			System.out.println("删除成功");
		else
			System.out.println("删除失败");
		sc.close();
	}
}
