<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		关系运算<br/><hr/>
		${ 12 == 12 } or ${ 12 eq 12 }<br/>
		${ 12 != 12 } or ${ 12 ne 12 }<br/>
		${ 12 < 12 } or ${ 12 lt 12 }<br/>
		${ 12 <= 12 } or ${ 12 le 12 }<br/>
		${ 12 > 12} or ${ 12 gt 12 }<br/>
		${ 12 >= 12 } or ${ 12 ge 12 }<br/><br/>
		
		逻辑运算<br/><hr/>
		${ 12 == 12 && 12 < 12 } or ${ 12 == 12 and 12 < 12 }<br/>
		${ 12 == 12 || 12 < 12} or ${ 12 == 12 or 12 < 12 }<br/>
		${ !false } or ${ not false }<br/><br/>
		
		算术运算<br/><hr/>
		${ 12 + 12 }<br/>
		${ 12 - 12 }<br/>
		${ 18 / 12 } or ${ 18 div 12 }<br/>
		${ 18 % 12 } or ${ 18 mod 12 }<br/><br/>
		
	</body>
</html>