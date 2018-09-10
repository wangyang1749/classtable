<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<ul id="nav">
<li><a href="es.do?method=getclass">我的课表</a></li>
<li><a href="es.do?method=schedule">其他课表</a></li>
<c:if test="${ybuser.type eq 1 }">
	<li><a href="ybus.admin?method=yulist">用户列表</a></li>
	<li><a href="upload.admin?method=uploadpage">用户上传</a></li>
</c:if>
<!--<c:choose>
	<c:when test="${ybuser.type eq 1 }">
		欢迎管理员[${ybuser.yb_realname }]来到该系统！！
	</c:when>
	<c:otherwise>
		欢迎用户[${ybuser.yb_realname }]来到该系统！！
	</c:otherwise>
</c:choose>
-->
</ul>