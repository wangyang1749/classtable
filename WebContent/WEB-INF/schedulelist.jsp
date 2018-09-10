<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>其他课表</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<div id="wapper">
	<jsp:include page="inc/top.jsp"></jsp:include>
	<table class="table">
	<tr>
		<td>
		<form action="es.do" method="get">
			<input type="hidden" name="method" value="schedule">
			<input type="search" name="con" value="${con }">
			<input type="submit" value="搜索">
		</form>
		</td>
	</tr>
	
	<c:forEach var="schedule" items="${schedules.getList() }">
		<tr>
			<td colspan="2"><a href="es.do?method=getotherclass&row=${schedule.classid }">${schedule.classname }</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="2">当前是第[${schedules.currentPage }]页。一共有[${schedules.totalRecord }]条记录 [${schedules.totoalPage }]页，一页显示[${schedules.pageSize }]条记录</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:choose>
				<c:when test="${con eq '' }">
					<a href="es.do?method=schedule&pageIndex=${schedules.currentPage-1 } ">上一页</a>
				</c:when>
				<c:otherwise>
					<a href="es.do?method=schedule&con=${con }&pageIndex=${schedules.currentPage-1 } ">上一页</a>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${con eq '' }">
					<a href="es.do?method=schedule&pageIndex=${schedules.currentPage+1 } ">下一页</a>
				</c:when>
				<c:otherwise>
					<a href="es.do?method=schedule&con=${con }&pageIndex=${schedules.currentPage+1 } ">下一页</a>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	</table>
	<jsp:include page="inc/footer.jsp"></jsp:include>
</div>

</body>
</html>