<%@page import="jxl.Cell"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/common.css">
<style type="text/css">
	
	
	
	
</style>
<title>我的课表</title>
</head>
<body>
<div id="wapper">
	<jsp:include page="inc/top.jsp"></jsp:include>
	<table class="table">
	<tr><th colspan="8">${cells[0].getContents()}</th></tr>
		<tr><th><div id="btn"></div></th><th>周一</th><th>周二</th><th>周三</th><th>周四</th><th>周五</th><th>周六</th><th>周日</th></tr>
		<c:forEach var="i"  begin="1" end="5">
			<tr>
				<td><span>第${i }节</span></td>
				<td>${cells[i].getContents() }</td>
				<td>${cells[i+5].getContents()} </td>
				<td>${cells[i+10].getContents()}</td>
				<td>${cells[i+15].getContents()} </td>
				<td>${cells[i+20].getContents()} </td>
				<td>${cells[i+25].getContents()} </td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="inc/footer.jsp"></jsp:include>

</div>
</body>
</html>