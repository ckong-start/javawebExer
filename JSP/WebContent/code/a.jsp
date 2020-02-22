<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
			pageContext.setAttribute("key", "pageContext");
			request.setAttribute("key", "request");
			session.setAttribute("key", "session");
			application.setAttribute("key", "application");
		%>
		pageContext = <%= pageContext.getAttribute("key") %><br/>
		request = <%= request.getAttribute("key") %><br/>
		session = <%= session.getAttribute("key") %><br/>
		application = <%= application.getAttribute("key") %><br/>
		
		<%
			request.getRequestDispatcher("/code/b.jsp").forward(request, response);
			
		%>
		<%-- <jsp:forward page="/code/b.jsp"></jsp:forward>--%>
	</body>
</html>