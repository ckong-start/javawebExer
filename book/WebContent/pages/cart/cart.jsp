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
				// 清空购物车
				$("#clearCart").click(function(){
					return confirm("是否要清空购物车");
				});
				
				$("a.deleteItemClass").click(function(){
					return confirm("是否要删除【"+ $(this).parent().parent().find("td:first").text() +"】？");
				});
				// 给数量的输入框绑定内容改变事件 
				$(".changeItemCount").change(function(){
					var count = this.value;
					var id = $(this).attr("itemId");
					var $tdObj = $(this).parent().parent().find("td:eq(3)");
					
					if(confirm("是否要将【" + $(this).parent().prev("td").text() + "】的数量改为：【" + count + "】")){
						// 点击了确定 ==发请求到服务器保存修改
						 //location.href = "http://localhost:8080/book/cartServlet?action=updateItem&id=" + id + "&count=" + count;
						//使用Ajax请求修改功能为异步请求
						$.getJSON("${basePath}cartServlet","action=ajaxUpdateItem&id=" + id + "&count=" + count,function(data){
							console.log(data);
							$("span.b_count").text(data.cartTotalCount);
							$(".b_price").text(data.cartTotalPrice);
							$tdObj.text(data.updateItemTotalPrice);
						});
					}else{
						// 点击了取消   恢复原有数量
						this.value = this.defaultValue;
					}
				});
			});
		</script>
	</head>	
	<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<span class="wel_word">购物车</span>
				<%@ include file="/pages/common/login_success_menu.jsp" %>
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
				<%--购物车为空的情况 --%>
				<c:if test="${ empty sessionScope.cart.items }">
					<tr><td colspan="5">亲，您的购物车没有商品，请点击这里<a href="index.jsp">去购物</a>吧~~</td></tr>
				</c:if>
				<%--购物车不为空的情况 --%>
				<c:if test="${ not empty sessionScope.cart.items }">
					<c:forEach items="${ sessionScope.cart.items }" var="entry">
					<tr>
						<td>${ entry.value.name }</td>
						<td><input class="changeItemCount" itemId="${ entry.value.id }" type="text" value="${ entry.value.count }" style="width:60px;"/></td>
						<td>${ entry.value.price }</td>
						<td>${ entry.value.totalPrice }</td>
						<td><a class="deleteItemClass" href="cartServlet?action=deleteItem&id=${ entry.value.id }">删除</a></td>
					</tr>	
					</c:forEach>	
				</c:if>
			</table>
			<%--购物车不为空的情况 --%>
			<c:if test="${ not empty sessionScope.cart.items }">
				<div class="cart_info">
					<span class="cart_span">购物车中共有<span class="b_count">${ sessionScope.cart.totalCount }</span>件商品</span>
					<span class="cart_span">总金额<span class="b_price">${ sessionScope.cart.totalPrice }</span>元</span>
					<span class="cart_span"><a id="clearCart" href="cartServlet?action=clearCart">清空购物车</a></span>
					<c:if test="${ not empty sessionScope.user }">
						<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
					</c:if>
					<c:if test="${ empty sessionScope.user }">
						<span class="cart_span"><a href="pages/user/login.jsp">去结账</a></span>
					</c:if>
				</div>
			</c:if>
		</div>
		<%@ include file="/pages/common/footer.jsp" %>
	</body>
</html>