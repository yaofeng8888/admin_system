<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>办公自动化管理系统</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<script>
	function setit() {
		document.forms[0].submit();
	}
</script>
</head>

<body>
	<div class="top">
		<div class="global-width">
			<img src="${pageContext.request.contextPath}/Images/logo.gif"
				class="logo" />
		</div>
	</div>
	<div class="status">
		<div class="global-width">
			${findUser.emp_name }你好！欢迎访问办公管理系统！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="${pageContext.request.contextPath }/user/logout">注销</a>
		</div>
	</div>
	<form id="myForm" name="myForm" action="userInfo!editData.action"
		method="post">
		<input type="hidden" name="u.id" value="26" /> <input type="hidden"
			name="u.sex" value="2" id="u_sex" /> <input type="hidden"
			name="u.supper" value="0" id="u_supper" />
		<div class="main">
			<div class="global-width">


				<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
				<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>办公自动化管理系统</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="nav" id="nav">
		<div class="t"></div>
		<dl>
			<dt
				onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息管理
			</dt>
			<dd>
				<a href="${pageContext.request.contextPath}/user/personinfor"
					target="_self">个人信息</a>
			</dd>
		</dl>
		<dl>
			<dt
				onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
				邮件管理</dt>
			<dd>
				<a href="${pageContext.request.contextPath }/user/writeEmail"
					target="_self">写邮件</a>
			</dd>
			<dd>
				<a href="${pageContext.request.contextPath }/user/reviceEmail"
					target="_self">收邮件</a>
			</dd>
			<dd>
				<a href="${pageContext.request.contextPath }/user/junkEmail"
					target="_self">垃圾邮件</a>
			</dd>
		</dl>
		<dl>
			<dt
				onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
				考勤管理</dt>
			<c:if test="${findUser.isAdmin == 0}">
				<dd>
					<a href="${pageContext.request.contextPath}/user/toleavelist"
						target="_self">休假</a>
				</dd>
			</c:if>
			<c:if test="${findUser.isAdmin == 1}">
				<dd>
					<a
						href="${pageContext.request.contextPath}/user/showAllLeave?emp_name=${findUser.emp_name}"
						target="_self">审核</a>
				</dd>
			</c:if>
		</dl>

		<dl>

			<dt
				onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
				权限管理</dt>
			<dd>
				<a href="${pageContext.request.contextPath}/user/personAccount"
					target="_self">个人账户</a>
			</dd>
			<c:if test="${findUser.isAdmin == 1}">
				<dd>
					<a href="${pageContext.request.contextPath}/user/adminAccount"
						target="_self">管理账户</a>
				</dd>
			</c:if>
		</dl>
	</div>
</body>
				</html>

				<div class="action">
					<div class="t">垃圾邮件列表</div>
					<div class="pages">
						<table width="90%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="left" width="18%">邮件标题</td>
								<td align="left" width="18%">内容</td>
								<td align="left" width="18%">是否以读</td>
								<td align="left" width="18%">时间</td>
								<td align="left" width="18%">操作</td>
							</tr>
							<c:forEach items="${findAll}" var="all">
								<tr>
									<td align="left">${all.email_title}</td>
									<td align="left">${all.email_body}</td>
									<c:if test="${all.isRead == 0}">
										<td align="left">未读</td>
									</c:if>
									<c:if test="${all.isRead == 1}">
										<td align="left">已读</td>
									</c:if>
									<td align="left">${all.sendTime}</td>
									<td><a href="javascript:void(0);"
										onclick="deleteEmail('${all.email_id}')">删除</a> |<a
										href="${pageContext.request.contextPath }/user/restoreEmail?email_id=${all.email_id}">还原</a>
									</td>
								</tr>
							</c:forEach>
						</table>

					</div>
				</div>
			</div>
		</div>
	</form>
	<div class="copyright">Copyright &nbsp; &copy; &nbsp;</div>
	<script type="text/javascript">
		function deleteEmail(email_id) {
			var con = confirm("确定彻底删除吗?"); //在页面上弹出对话框
			if (con == true) {

				location.href ="${pageContext.request.contextPath}/user/delete?email_id="
						+ email_id;
			}
		}
	</script>

</body>
</html>