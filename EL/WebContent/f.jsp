<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%= request.getServerName() %><br/><hr/>
		1.协议：${ pageContext.request.scheme } <br/>
		2.服务器ip：${ pageContext.request.serverName }<br/>
		3.服务器端口号：${ pageContext.request.serverPort }<br/>
		4.获取工程路径：${ pageContext.request.contextPath }<br/>
		5.获取请求方法：${ pageContext.request.method }<br/>
		6.获取客户端ip地址：${ pageContext.request.remoteHost }<br/>
		7.获取会话的id编号：${ pageContext.session.id }<br/>
	</body>
</html>