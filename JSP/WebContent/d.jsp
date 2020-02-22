<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="exer.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table{
				width: 500px;
				border: 1px solid red;
				border-collapse: collapse;
			}
			th , td{
				border: 1px solid red;
			}
		</style>
	</head>
	<body>
		<%--  练习三：jsp输出一个表格，里面有20个学生信息。--%>
		<%
		 	/* List<Student> stus = new ArrayList<Student>();
			for(int i = 1;i <= 20;i++){
				stus.add(new Student(i,"name" + i,i % 2 == 0 ? "男" : "女",10 + i,"13300" + i));
			}
			for(Student stu : stus){
				System.out.println(stu);
			}  */
		%>
		<table>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>电话</th>
				<th>操作</th>
			</tr>
			<%
			List<Student> stus = (List<Student>) request.getAttribute("stus");
			for(int i = 0;i < 20;i++){%>
				<% Student stu = stus.get(i); %>
				<tr>
					<td><%=stu.getId() %></td>
					<td><%=stu.getName() %></td>
					<td><%=stu.getSex() %></td>
					<td><%=stu.getAge() %></td>
					<td><%=stu.getPhone() %></td>
					<td align="center">修改，删除</td>
				</tr>
			<%}%>
		</table>
	</body>
</html>