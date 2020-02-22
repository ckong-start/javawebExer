<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			System.out.println("admin下的jsp执行了");
			Object user = session.getAttribute("user");
			if (user == null) { // 说明还没登录
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return ;
			}
		%>
		这是admin目录下的b.jsp
	</body>
</html>