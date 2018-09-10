<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户列表</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<div id ="wapper">
	<jsp:include page="inc/top.jsp"/>
	<table class="table">
		<tr>
			<td colspan="10">
				<form action="ybus.admin" method="get">
				<input type="hidden" name="method" value="yulist">
				<input type="search" name="con" value="${con }">
				<input type="submit" value="搜索">
			</form>
			</td>
		</tr>
		<tr><th>用户ID</th> <th>真实姓名</th><th>学校ID</th> <th>学校</th> <th>学院</th> <th>班级</th> <th>用户ID</th> <th>学号</th> <th>类型</th> <th>状态</th> </tr>
		<c:forEach var="user" items="${user.getList() }">
			<tr>
				<td>${user.yb_userid }</td> <td>${user.yb_realname }</td> <td>${user.yb_schoolid }</td> <td>${user.yb_schoolname }</td> <td>${user.yb_collegename }</td> <td>${user.yb_classname }</td> <td>${user.yb_enteryear }</td> <td>${user.yb_studentid }</td>
				<c:choose>
					<c:when test="${user.type eq 1 }">
						<td id="type"><button onclick="setType(${user.yb_userid },0)">管理员</button></td> 
					</c:when>
					<c:when test="${user.type eq 0 }">
						<td id="type"><button onclick="setType(${user.yb_userid},1)">普通用户</button></td> 
					</c:when>
				</c:choose>				
				<c:choose>
					<c:when test="${user.state eq 1 }">
						<td id="state"><button onclick="setState(${user.yb_userid},0)">启用</button></td> 
					</c:when>
					<c:when test="${user.state eq 0 }">
						<td id="state"><button onclick="setState(${user.yb_userid},1)">禁用</button></td> 
					</c:when>
				</c:choose>	
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">当前是第[${user.currentPage }]页。一共有[${user.totalRecord }]条记录 [${user.totoalPage }]页，一页显示[${user.pageSize }]条记录</td>
		</tr>
		<tr>
			<td colspan="10">
				<a href="ybus.admin?method=yulist&pageIndex=${user.currentPage -1}">上一页</a>
				<a href="ybus.admin?method=yulist&pageIndex=${user.currentPage +1}">下一页</a>
			</td>
		</tr>
	</table>
	<jsp:include page="inc/footer.jsp"></jsp:include>
	
<script type="text/javascript" src="js/admin.js">
	
</script>	
</div>
</body>
</html>