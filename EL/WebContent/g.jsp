<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		param输出参数：${ param.username }<br/>
		paramValues输出参数：${ paramValues.hobby[1] }<br/>
		
		header输出请求头：${ header['Accept-Language'] }<br/>
		headerValues输出请求头：${ headerValues['Accept-Language'][0] }<br/>
		
		cookies输出Cookie的值：${ cookie.JSESSIONID }
	</body>
</html>