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
			int i = 10;
			if(i == 10){
				System.out.println(i);
			}else {
				System.out.println("没有输出i");
			}
		%>
		<%
			for(;i < 20;i++){
				System.out.println(i);
			}
		%>
		<%= 
			i
		%>
		<%
			String str = request.getParameter("username");
			System.out.println("username:" + str);
			str = request.getParameter("password");
			System.out.println("password:" + str);
		%>
	</body>
</html>