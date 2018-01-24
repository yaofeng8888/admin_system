<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>办公自动化管理系统</title>
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
		<script>
			function setit()
			{
				document.forms[0].submit();
			}
		</script>
	</head>
	
	<body>
		<div class="top">
			<div class="global-width">
				<img src="${pageContext.request.contextPath}/Images/logo.gif" class="logo" />
			</div>
		</div>
		<div class="status">
			<div class="global-width">
				${findUser.emp_name }你好！欢迎访问办公管理系统！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/user/logout">注销</a>
			</div>
		</div>
		<form id="myForm" name="myForm" action="userInfo!editData.action" method="post">
		<input type="hidden" name="u.id" value="26"/>
		<input type="hidden" name="u.sex" value="2" id="u_sex"/>
		<input type="hidden" name="u.supper" value="0" id="u_supper"/>
		<div class="main">
			<div class="global-width">
				
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>办公自动化管理系统</title>
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	</head>
  
  <body>
    <div class="nav" id="nav">
					<div class="t"></div>
					<dl>
							<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息管理 
						</dt>
						<dd>
							<a href="${pageContext.request.contextPath}/user/personinfor" target="_self">个人信息</a>
						</dd>
					</dl>
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							邮件管理
						</dt>
						<dd>
							<a href="${pageContext.request.contextPath }/user/writeEmail" target="_self">写邮件</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/user/reviceEmail" target="_self">收邮件</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/user/junkEmail" target="_self">垃圾邮件</a>
						</dd>
					</dl>
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							考勤管理
						</dt>
						<c:if test="${findUser.isAdmin == 0}">
						<dd>
							<a href="${pageContext.request.contextPath}/user/toleavelist" target="_self">休假</a>
						</dd>
							</c:if>
						<c:if test="${findUser.isAdmin == 1}">
						<dd>
							<a href="${pageContext.request.contextPath}/user/showAllLeave?emp_name=${findUser.emp_name}" target="_self">审核</a>
						</dd>
						</c:if>
					</dl>
					
					<dl >
					
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							权限管理
						</dt>
						<dd>
							<a href="${pageContext.request.contextPath}/user/personAccount" target="_self">个人账户</a>
						</dd>
						<c:if test="${findUser.isAdmin == 1}">
						<dd>
							<a href="${pageContext.request.contextPath}/user/adminAccount" target="_self">管理账户</a>
						</dd>
						</c:if>
					</dl>
				</div>
  </body>
</html>
 
					<div class="action">
						<div class="t">
							休假列表
						</div>
						<div class="pages">
							<table width="50%" border="0" cellspacing="0" cellpadding="0">
							<tr>
							<td>申请人</td>
							<td>开始时间</td>
							<td>结束时间</td>
							<td>天数</td>
							<td>审批状态</td>
							<td>原因</td>
							<c:if test="${findUser.isAdmin == 1 }">
								<td>操作</td>
								</c:if> 
							</tr>
								<c:forEach items="${leavelist }" var="list">
								<tr>
								<td><input type ="text"  value="${list.emp_name }"readonly="readonly" /></td>
								<td><input type="text"	 value="${list.start }" readonly="readonly"  /></td>
								<td><input type = "text"  value="${list.end }"readonly="readonly" /></td>
								<td><input type = "text"  value="${list.days }"readonly="readonly" /></td>
								 <c:if test="${list.state == 1 }">
								<td><input type = "text"  value="未审核"readonly="readonly" /></td>
								</c:if>
								<c:if test="${list.state == 0 }">
								<td><input type = "text"  value="已审核"readonly="readonly" /></td>
								</c:if> 
								<c:if test="${list.state == 2 }">
								<td><input type = "text"  value="审核拒绝"readonly="readonly" /></td>
								</c:if> 
								<td><input type = "text"  value="${list.reason }"readonly="readonly" /></td>
								</tr>
								<c:if test="${findUser.isAdmin == 1 }">
								<td><a href="${pageContext.request.contextPath }/user/dealleave?leave_id=${list.leave_id}">审核</a></td>
								</c:if> 
								</c:forEach>
								<tr>
								<td><a href="${pageContext.request.contextPath }/user/applyleave"><input type="button" value="申请休假"></a></td>
								</tr>
								</table>							
						</div>
					</div>
			</div>
		</div>
		</form>
		<div class="copyright">
			Copyright &nbsp; &copy; &nbsp; 
		</div>
 
	</body>
</html>