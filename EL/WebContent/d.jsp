<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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
			request.setAttribute("emptyNull", null);
			request.setAttribute("emptyStr", "");
			request.setAttribute("emptyArr", new Object[]{});
			request.setAttribute("emptyList", new ArrayList());
			request.setAttribute("emptyMap", new HashMap());
		%>
		${ empty emptyNull }<br/>
		${ empty emptyStr }<br/>
		${ empty emptyArr }<br/>
		${ empty emptyList }<br/>
		${ empty emptyMap }<br/>
		<hr/>
		${ 12 > 12 ? "对" : "错" }
	</body>
</html>