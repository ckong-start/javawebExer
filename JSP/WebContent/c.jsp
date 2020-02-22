<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
				table{
					width: 600px;
					border: 0px solid red;
					border-collapse: collapse;
				}
				th , td{
					border: 0px solid red;
				}
		</style> 
	</head>
	<body>
		<!-- 练习二：在jsp中输出九九乘法口诀表 -->
		<center>
			<table>
			<%for(int i = 1;i <= 9;i++){%>
				<tr>
					<%for(int j = 1;j <= i;j++){%>
						<td> <%= i + "*" + j + "=" + i * j %></td>
					<%}%>
				</tr>
			<%}%>
		</table>
		</center>
	</body>
</html>