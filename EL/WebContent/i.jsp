<%@page import="pojo.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pojo.Student"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 500px;
	border: 1px solid red;
	border-collapse: collapse;
}

th, td {
	border: 1px solid red;
}
</style>
</head>
<body>
	<c:forEach begin="1" end="10" var="i">
		<div>${ i }</div>
	</c:forEach>
	<hr />
	<%
		request.setAttribute("arr", new String[] { "18610541354", "18688886666", "13988889999" });
	%>
	<c:forEach items="${ requestScope.arr }" var="str">
		<p>${ str }</p>
	</c:forEach>
	<hr />

	<%
		Map<String, Object> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		request.setAttribute("map", map);
	%>
	<c:forEach items="${ requestScope.map }" var="entry">
		<div>${ entry.key }->${ entry.value }</div>
	</c:forEach>
	<hr />
	<%
		List<Student> stus = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			stus.add(new Student(i, "name" + i, i % 2 == 0 ? "女" : "男", 18 + i, "phone" + i));
		}
		request.setAttribute("list", stus);
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
		<c:forEach items="${ requestScope.list }" var="stu" varStatus="status">
			<c:if test="${ status.count == 2 }">
				<tr bgcolor="yellow">
			</c:if>
			<c:if test="${ status.count != 2 }">
				<tr>
			</c:if>
			<td>${ stu.id }</td>
			<td>${ stu.name }</td>
			<td>${ stu.sex }</td>
			<td>${ stu.age }</td>
			<td>${ stu.phone }</td>
			<td align="center">删除、修改</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>