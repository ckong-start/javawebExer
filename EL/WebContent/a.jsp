<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
			request.setAttribute("abc", "abcValue");
		%>
		jsp输出：<%= request.getAttribute("abc") %><br/>
		El输出：${abc}<br/>
		<%
			Map<String,Object> map = new HashMap<>();
			map.put("aaa","aaaValue");
			map.put("bbb","bbbValue");
			map.put("ccc","cccValue");
			request.setAttribute("map1", map);
		%>
		<hr/>
		${ map1.aaa }<br/>
		${ map1['aaa'] }<br/>
	</body>
</html>