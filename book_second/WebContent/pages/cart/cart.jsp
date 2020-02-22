<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>购物车</title>
		<%@include file="/pages/common/head.jsp" %>
		<script type="text/javascript">
			$(function(){
				$(".deleteItem").click(function(){
					return confirm("确定是否删除【" + $(this).attr("itemName") + "】吗？");
				});
				$("#clearCart").click(function(){
					return confirm("是否要清空购物车？");
				});
				$(".updateCount").change(function(){
					var count = this.value;
					var itemId = $(this).attr("itemId");
					$.getJSON("http://localhost:8080/book_second/cartServlet", "action=ajaxUpdateCount&itemId=" + itemId + "&count=" + count, function(date){
						
					});
				});
			});
		</script>
	</head>
	<body>
		
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@include file="/pages/common/login_success_menu.jsp" %>
		</div>
		
		<div id="main">
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>
				<c:if test="${ empty sessionScope.cart.items }">
					<tr><td colspan="5"><span>您购物车中没有商品，请点击这里<a href="index.jsp">去购物</a>吧~</span></td></tr>
				</c:if>
				<c:if test="${ not empty sessionScope.cart }">
					<c:forEach items="${ sessionScope.cart.items }" var="book">
						<tr>
							<td>${ book.name }</td>
							<td><input class="updateCount" itemId="${ book.id }" type="text" value="${ book.count }" style="width:60px;"/></td>
							<td>${ book.price }</td>
							<td>${ book.totalPrice }</td>
							<td><a class="deleteItem" itemName="${ book.name }" href="cartServlet?action=delete&id=${ book.id }">删除</a></td>
						</tr>	
					</c:forEach>
				</c:if>
			</table>
			<div class="cart_info">
				<c:if test="${ not empty sessionScope.cart.items }">
					<span class="cart_span">购物车中共有<span class="b_count">${ sessionScope.cart.totalCount }</span>件商品</span>
					<span class="cart_span">总金额<span class="b_price">${ sessionScope.cart.totalPrice }</span>元</span>
					<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
					<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
				</c:if>
			</div>
		</div>
	<%@include file="/pages/common/footer.jsp" %>
	</body>
</html>