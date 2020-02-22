<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div>
		<span>欢迎<span class="um_span">${ sessionScope.user.username }</span>光临尚硅谷书城</span>
		<a href="orderServlet?action=listOrder">我的订单</a>
		<c:if test="${ not empty sessionScope.user }">
			<a href="userServlet?action=loginOut">注销</a>&nbsp;&nbsp;
		</c:if>
		<a href="index.jsp">返回</a>
	</div>