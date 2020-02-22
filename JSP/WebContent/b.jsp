<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
				table{
					width: 1000px;
					border: 1px solid red;
					border-collapse: collapse;
				}
				th , td{
					border: 1px solid red;
				}
			</style>
	</head>
	<body>
		<!-- 练习一：输出n*m的表格 -->
		<form action="http://localhost:8080/JSP/b.jsp" method="post">
			输入行数：<input type="text" name="row"/><br/>
			输入列数：<input type="text" name="col"/><br/>
			<input type="submit" value="确定"/> 
		</form>
		<%
			String row = request.getParameter("row");
			String col = request.getParameter("col");
			row = row == null ? "0" : row;
			col = col == null ? "0" : col;
		%>
		
		<table>
		<% 
			if(row.length() != 0 && col.length() != 0){
				int n = Integer.parseInt(row);
				int m = Integer.parseInt(col);%>
			<%for(int i = 1;i <= n;i++){%>
				<tr>
					<%for(int j = 1;j <= m;j++){%>
					<td>
						<%= 
							i + "-" + j
						%>
					</td>
			<%		}%>
				</tr>
			<%	}}%>
		</table>
	</body>
</html>