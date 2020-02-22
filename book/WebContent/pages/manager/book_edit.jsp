<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@include file="/pages/common/head.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
	<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@include file="/pages/common/manager_menu.jsp" %>
		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="post">
				<input type="hidden" name="action" value="${ empty requestScope.book ? "add" : "update" }" />
				<%-- <input type="hidden" name="action" value="${ empty param.id ? "add" : "update" }" /> --%>
				<%-- <input type="hidden" name="action" value="${ param.method }" /> --%>
				<input type="hidden" name="id" value="${ requestScope.book.id }" />
				<input type="hidden" name="pageNo" value="${ param.pageNo }" />
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td>封面</td>
						<td colspan="1">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${ requestScope.book.name }"/></td>
						<td><input name="price" type="text" value="${ requestScope.book.price }"/></td>
						<td><input name="author" type="text" value="${ requestScope.book.author }"/></td>
						<td><input name="sales" type="text" value="${ requestScope.book.sales }"/></td>
						<td><input name="stock" type="text" value="${ requestScope.book.stock }"/></td>
						<td><input name="imgPath" type="file" /></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
		</div>
		<%@ include file="/pages/common/footer.jsp" %>
	</body>
</html>