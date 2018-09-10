<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>错误页面</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<div id="wapper">
	<jsp:include page="inc/top.jsp"></jsp:include>
	${error }
	<jsp:include page="inc/footer.jsp"></jsp:include>
</div>

</body>
</html>