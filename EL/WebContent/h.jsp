<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		保存之前：${ requestScope.abc }<br/>
		<c:set scope="request" var="abc" value="abcValue"></c:set>
		保存之后：${ abc }<br/>
		<hr/>
		<c:if test="${ 12 == 12 }">
			<div>12真的等于12</div>
		</c:if>
		<hr/>
		<c:set scope="request" var="height" value="149"></c:set>
		<c:choose>
			<c:when test="${ height >= 195}">
				<div>11</div>
			</c:when>
			<c:when test="${ height >= 185}">
				<div>22</div>
			</c:when>
			<c:when test="${ height >= 175}">
				<div>33</div>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${ height >= 165 }">
						<div>44</div>
					</c:when>
					<c:when test="${ height >= 155 }">
						<div>55</div>
					</c:when>
					<c:when test="${ height >= 145 }">
						<div>66</div>
					</c:when>
				</c:choose>
			</c:otherwise>
		</c:choose>
		<hr/>
	</body>
</html>