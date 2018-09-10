<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户上传</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<div id="wapper">
	<jsp:include page="inc/top.jsp"/>
	<c:if test="${result eq null }">
		一共添加了${result }条数据
		<hr>
	</c:if>
	${result }
	<form method="post" action="upload.admin?method=upload" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="上传">
	</form>
	<jsp:include page="inc/footer.jsp"></jsp:include>
</div>
</body>
</html>