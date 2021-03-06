<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户登录</title>
 
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}
	
	body {
		font: 12px 宋体;
		background: #4BB8EF url(${pageContext.request.contextPath}/Images/bg.gif) repeat-x;
	}
	
	img {
		border: 0;
	}
	
	.login-top {
		width: 100%;
		height: 186px;
		margin: 147px auto 0;
		background: url(${pageContext.request.contextPath}/Images/login_01.gif) no-repeat center 0;
	}
	
	.login-area {
		width: 100%;
		height: 140px;
		margin: 0 auto;
		background: url(${pageContext.request.contextPath}/Images/login_02.gif) no-repeat center 0;
	}
	
	.login-area form {
		width: 290px;
		margin: 0 auto;
	}
	
	.login-area label {
		clear: left;
		margin-top: 13px;
		width: 60px;
		font: 600 14px 宋体;
	}
	
	.login-area  input {
		width: 122px;
		height: 16px;
		margin-top: 11px;
		border: 1px #767F94 solid;
		font: 12px/ 16px 宋体;
	}
	
	input.login-sub {
		width: 204px;
		height: 34px;
		border: 0;
		background: url(${pageContext.request.contextPath}/Images/login_sub.gif) no-repeat 90px 1px; *
		margin-top: 5px;
	}
	
	.login-copyright {
		width: 100%;
		height: 30px;
		margin: 18px auto 0;
		background: url(${pageContext.request.contextPath}/Images/copyright.gif) no-repeat center 0;
	}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
</head>
 
<body>
	<div class="login-top"></div>
	<div class="login-area">
		<form  id="userForm" >
			<label>
				工&nbsp;&nbsp;号：
			</label>
			<input type="text" name="emp_name" />
			<br>
			<label>
				密&nbsp;&nbsp;码：
			</label>
			
			<input type="password" name="emp_password" />
			
			<input type="submit" class="login-sub" value="" />
			<br/>
				<b><font color="red" id="mess"></font></b>
		</form>
	</div>
	<div class="login-copyright"></div>
</body>
<script type="text/javascript">

//表单校验
$(function() {
	$("#userForm").validate({
						rules : {
							emp_name : "required",
							emp_password : "required"
						},
						messages : {
							emp_name : "工号不能为空",
							emp_password : "密码不能为空"
						},
						submitHandler : function() {
							//提交Ajax
							 $.ajax({
										data : $("#userForm").serialize(),
										dataType : "text",
										type : "post",
										url : "${pageContext.request.contextPath}/user/checkuser",
										success : function(rec) {
											if(rec=="0"){
												$("#mess").html("用户名或密码错误");
											}else{
												location.href = "${pageContext.request.contextPath}/user/toindex"
											}	
										}
									}); 
						}
					});
})

</script>

</html>
