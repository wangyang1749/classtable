<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="user" uri="/user" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户列表页面</title>
<link rel="stylesheet" href="css/common.css">
<script type="text/javascript">

	function ajax(){
			
			
		}
	ajax.prototype.getAjax(){
		alert("sss");
		var xmlhttp;
		if (window.XMLHttpRequest){
			// code for IE7+, Firefox, Chrome, Opera, Safari
		 	xmlhttp=new XMLHttpRequest();
		}else{// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		/*xmlhttp.onreadystatechange=function() {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
		   }
		 }*/
		xmlhttp.open("GET","us?method="+id,true);
		xmlhttp.send();
	}


  		function deleteUser(){
  			alert("444");
  		}
  		
</script>
</head>
<body>

<div id="wapper">
	<jsp:include page="inc/top.jsp"/>
	
	<table class="table">
	<tr><th>用户Id</th> <th>用户名</th>  <th>用户昵称</th> <th>用户密码</th> <th>用户类型</th> <th>用户状态</th><th>注册时间</th><th>操作</th></tr>
	<c:forEach var="u" items="${user }" >
		<tr>
			<td>${u.id}</td><td>${u.username }</td> <td>${u.nickname }</td><td>${u.password }</td>
			
			<td>${u.type }</td><td>${u.status }</td>
			
			<td>${user:getDate(u.date)}</td><td><div onclick="deleteUser(${u.id})" style="cursor:pointer">删除</div></td>
		</tr>
	</c:forEach>
	</table>
</div>
<hr>

${user }
<c:out value="hhhh"></c:out>
</body>
</html>