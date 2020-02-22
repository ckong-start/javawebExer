<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>订单详情</title>
		<%@include file="/pages/common/head.jsp" %>
	</head>
	<body>
		
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单详情</span>
			<%@include file="/pages/common/login_success_menu.jsp" %>
		</div>
		
		<div id="main">
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
				</tr>
				<c:forEach items="${ requestScope.orderItems }" var="item">
					<tr>
						<td>${ item.name }</td>
						<td>${ item.count }</td>
						<td>${ item.price }</td>
						<td>${ item.totalPrice }</td>
					</tr>	
				</c:forEach>
			</table>
			<div class="cart_info"></div>
		</div>
	<%@include file="/pages/common/footer.jsp" %>
	</body>
</html>