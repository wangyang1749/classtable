<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="css/common.css">
<style type="text/css">
	.form{
		margin: 0 auto;
		border-collapse: collapse;
		text-align: center;
		height: 15em;
    	width: 22em;
	}
	.form,.form tr,.form td{
		border: 1px solid #98bf21;
	}
	.form input[type="text"]{
		font-size: 1.3em;
		border: none;
		outline: none;
		
	}
	.form input[type="submit"],.form input[type="reset"]{
		border: navajowhite;
	    background: #5dcd5d;
	    width: 4em;
	    height: 1.5em;
	    border-radius: 1em;
	}
	.form input[type="reset"]{
		margin-right: 10em;
	}
</style>
</head>
<!-- private int ybUserid;
	private String ybUsername;
	private String ybNickname;
	private String ybSex;
	private int ybMoney;
	private int ybExp;
	private String ybUserhead;
	private int ybSchoolid;
	private String ybSchoolname;
	private String ybTime;
	private int type;
	private int state; -->
<body>
	<div id="wapper">
	<jsp:include page="inc/top.jsp"></jsp:include>
		<form action="us?method=add" method="post">
		<table class="form">
			<tr><td>用户名：</td><td colspan="2"><input type="text" name="username" placeholder="请输入用户名"></td></tr>
			<tr><td>用昵称</td><td colspan="2"><input type="text" name="nickname" placeholder="请输入用户昵称"></td></tr>
			<tr><td>密码：</td><td colspan="2"><input type="text" name="password" placeholder="请输入密码"></td></tr>
			
			<tr><td>用户性别：</td><td><span>男:</span><input type="radio" name="ybSex" value="0"></td><td><span>女:</span><input type="radio" name="ybSex" value="1"></td></tr>
			<tr><td colspan="3"><input type="reset" value="重置"><input type="submit" value="提交"></td></tr>
		</table>	
		</form>
	</div>
</body>
</html>