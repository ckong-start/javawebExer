<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--分页的开始 --%>
	<div id="page_nav">
		<%--判断首页是否可用 --%>
		<c:if test="${ requestScope.page.pageNo == 1 }">
			<a href="${ requestScope.page.uri }&pageNo=1" unable="true">首页</a>
			<a href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageNo - 1 }" unable="true">上一页</a>
		</c:if>
		<c:if test="${ requestScope.page.pageNo > 1 }">
			<a href="${ requestScope.page.uri }&pageNo=1">首页</a>
			<a href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageNo - 1 }">上一页</a>
		</c:if>
		<c:choose>
			<%-- 第一种情况：总页码数小于等于5的情况， 页码范围是： 1 - 总页码 --%>
			<c:when test="${ requestScope.page.pageTotal <= 5 }">
				<c:set var="begin" value="1"/>
				<c:set var="end" value="${ requestScope.page.pageTotal }"/>
			</c:when>
			<%-- 第二种情况：总页码数大于5的情况 --%>
			<c:when test="${ requestScope.page.pageTotal > 5 }">
				<c:choose>
				<%-- 第一种小情况：当前页码为前面3个，也就是第1,2,3页。页码范围是：1 - 5 固定  --%>
					<c:when test="${ requestScope.page.pageNo <= 3 }">
						<c:set var="begin" value="1"/>
						<c:set var="end" value="5"/>
					</c:when>
				<%-- 第二种小情况：当前页码为最后3个，也就是8,9,10页.页码范围是：总页码-4 到 总页码 --%>
					<c:when test="${ requestScope.page.pageNo >  requestScope.page.pageTotal - 3}">
						<c:set var="begin" value="${ requestScope.page.pageTotal - 4 }"/>
						<c:set var="end" value="${ requestScope.page.pageTotal }"/>							
					</c:when>
				<%--第三种小情况：剩下中间的页码，也就是4,5,6,7页。页码范围是： 当前页码-2 到 当前页码+2--%>
					<c:otherwise>
						<c:set var="begin" value="${ requestScope.page.pageNo - 2 }"/>
						<c:set var="end" value="${ requestScope.page.pageNo + 2 }"/>							
					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose>
		<c:forEach begin="${ begin }" end="${ end }" var="i">
			<c:if test="${ requestScope.page.pageNo == i }">
				【${ i }】
			</c:if>
			<c:if test="${ requestScope.page.pageNo != i }">
				<a href="${ requestScope.page.uri }&pageNo=${ i }" >${ i }</a>
			</c:if>
		</c:forEach>
		<c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal }">
			<a href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageNo + 1 }">下一页</a>
			<a href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageTotal }">末页</a>
		</c:if>
		<c:if test="${ requestScope.page.pageNo == requestScope.page.pageTotal }">
			<a href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageNo + 1 }" unable="true">下一页</a>
			<a href="${ requestScope.page.uri }&pageNo=${ requestScope.page.pageTotal }" unable="true">末页</a>
		</c:if>
		共${ requestScope.page.pageTotal }页，${ requestScope.page.pageTotalCount }条记录 
		到第<input value="${ requestScope.page.pageNo }" name="pn" id="pn_input"/>页
		<input id="searchBtn" type="button" value="确定">
	</div>
	<script type="text/javascript">
		$(function(){
			$("#searchBtn").click(function(){
				var pageNo = $("#pn_input").val();
				location.href = "${pageScope.basePath}${ requestScope.page.uri }&pageNo=" + pageNo;
			});
		});
	</script>
<%--分页的结束 --%>