<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="page_nav">
	<c:if test="${ requestScope.page.pageNo <= 1 }">
		<a unable="true" href="${ requestScope.page.uri }&pageNo=1">首页</a>
		<a unable="true" href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageNo - 1}">上一页</a>
	</c:if>
	<c:if test="${ requestScope.page.pageNo > 1 }">
		<a href="${ requestScope.page.uri }&pageNo=1" >首页</a>
		<a href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageNo - 1}">上一页</a>
	</c:if>
	<c:choose>
		<c:when test="${ requestScope.page.pageTotal <= 5 }">
			<c:set var="begin" value="1"/>
			<c:set var="end" value="${ requestScope.page.pageTotal }"/>
		</c:when>
		
		<c:when test="${ requestScope.page.pageTotal > 5 }">
			<c:choose>
				<c:when test="${ requestScope.page.pageNo <= 3 }">
					<c:set var="begin" value="1"/>
					<c:set var="end" value="5"/>
				</c:when>
				
				<c:when test="${ requestScope.page.pageNo >= requestScope.page.pageTotal - 2 }">
					<c:set var="begin" value="${ requestScope.page.pageTotal - 4}"/>
					<c:set var="end" value="${ requestScope.page.pageTotal }"/>
				</c:when>
				
				<c:otherwise>
					<c:set var="begin" value="${ requestScope.page.pageNo - 2 }"/>
					<c:set var="end" value="${ requestScope.page.pageNo + 2 }"/>
				</c:otherwise>
				
			</c:choose>
		</c:when>
	</c:choose>
	<c:forEach begin="${ begin }" end="${ end }" var="i">
		<c:if test="${ requestScope.page.pageNo != i }">
			<a href="${ requestScope.page.uri }&pageNo=${ i }">${ i }</a>
		</c:if>
		<c:if test="${ requestScope.page.pageNo == i }">
			【${ i }】
		</c:if>
	</c:forEach>
	<c:if test="${ requestScope.page.pageNo >= requestScope.page.pageTotal }">
		<a unable="true" href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageNo + 1}">下一页</a>
		<a unable="true" href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageTotal }">末页</a>
	</c:if>
	<c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal }">
		<a href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageNo + 1}">下一页</a>
		<a href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageTotal }">末页</a>
	</c:if>
	共${ requestScope.page.pageTotal }页，${ requestScope.page.pageTotalCount }条记录 到第<input value="${ requestScope.page.pageNo }" name="pn" id="pn_input"/>页
	<script type="text/javascript">
		$(function(){
			$("#jumpPage").click(function(){
				var toPageNo = $("#pn_input").val();
				location.href = "http://localhost:8080/book_second/${ requestScope.page.uri }&pageNo=" + toPageNo;
			});
		});
	</script>
	<input id="jumpPage" type="button" value="确定">
</div>