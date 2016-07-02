<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
<title>ExamStack</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="keywords" content="">
<link rel="shortcut icon"
	href="<%=basePath%>resources/images/favicon.ico" />
<link href="resources/bootstrap/css/bootstrap-huan.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<!-- Javascript files -->
<style type="text/css">
.form-group {
	margin-bottom: 5px;
	height: 59px;
}
</style>
</head>

<body>
	<header>
		<div class="container">
			<div class="row">
				<div class="col-xs-5">
					<div class="logo">
						<h1>
							<a href="#"><img alt="" src="resources/images/logo.png"></a>
						</h1>
					</div>
				</div>
				<div class="col-xs-7" id="login-info">
					<c:choose>
						<c:when
							test="${not empty sessionScope.user.username}">
							<div id="login-info-user">

								<a
									href="usercenter"
									id="system-info-account" target="_blank">${sessionScope.user.username}</a>
								<span>|</span> <a href="logout"><i
									class="logout"></i> 退出</a>
							</div>
						</c:when>
						<c:otherwise>
							<a class="btn btn-primary" href="register">用户注册</a>
							<a class="btn btn-success" href="login">登录</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</header>
	<!-- Navigation bar starts -->

	<div class="navbar bs-docs-nav" role="banner">
		<div class="container">
			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">
				<ul class="nav navbar-nav">
						<li>
							<a href="home"><i class="fa fa-home"></i>主页</a>
						</li>
						<li>
							<a href="practice-list"><i class="fa fa-edit"></i>试题练习</a>
						</li>
						<li>
							<a href="exam"><i class="fa  fa-paper-plane-o"></i>在线考试</a>
						</li>
						<li>
							<a href="usercenter"><i class="fa fa-cogs"></i>个人中心</a>
						</li>
					</ul>
			</nav>
		</div>
	</div>

	<!-- Navigation bar ends -->

	<div class="content" style="margin-bottom: 100px;">

		<div class="container">
			<div class="row">

				<div class="col-md-12">
					<div class="lrform">
						<h5>注册账号</h5>
						<span class="form-message"></span>
						<div class="form">
							<!-- Register form (not working)-->
							<form class="form-horizontal" id="form-create-account"
								action="test">
								<div class="form-line form-username" style="display: block;">
									<span class="form-label"><span class="warning-label">*</span>用户名：</span>
									<input type="text" class="df-input-narrow" id="name-add"
										maxlength="20"> <span class="form-message"></span> <br>
								</div>
								<div class="form-line form-password" style="display: block;">
									<span class="form-label"><span class="warning-label">*</span>密码：</span>
									<input type="password" class="df-input-narrow" id="password-add"
										maxlength="20"> <span class="form-message"></span> <br>
								</div>
								<div class="form-line form-password-confirm" style="display: block;">
									<span class="form-label"><span class="warning-label">*</span>重复密码：</span>
									<input type="password" class="df-input-narrow" id="password-add"
										maxlength="20"> <span class="form-message"></span> <br>
								</div>
								<div class="form-line form-truename" style="display: block;">
									<span class="form-label"><span class="warning-label">*</span>真实姓名：</span>
									<input type="text" class="df-input-narrow" id="truename-add"
										maxlength="20"> <span class="form-message"></span> <br>
								</div>
								<div class="form-line form-email" style="display: block;">
									<span class="form-label"><span class="warning-label">*</span>邮箱：</span>
									<input type="text" class="df-input-narrow" id="email-add"
										maxlength="60"> <span class="form-message"></span> <br>
								</div>

								<!-- Buttons -->
								<div class="form-group">
									<!-- Buttons -->
									<div class="col-md-9 col-md-offset-3">
										<button type="submit" class="btn" id="btn-reg">注册账号</button>
										<button type="reset" class="btn">重置</button>
									</div>
								</div>
							</form>
							已有账号? <a href="user-login-page">直接登录</a>
						</div>
					</div>

				</div>
			</div>

		</div>

	</div>
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="copy">
						<p>
							ExamStack Copyright © <a href="http://www.examstack.com/"
								target="_blank">ExamStack</a> - <a href="." target="_blank">主页</a>
							| <a href="http://www.examstack.com/" target="_blank">关于我们</a> | <a
								href="http://www.examstack.com/" target="_blank">FAQ</a> | <a
								href="http://www.examstack.com/" target="_blank">联系我们</a>
						</p>
					</div>
				</div>
			</div>

		</div>

	</footer>

	<!-- Slider Ends -->
	<!-- jQuery -->
	<script type="text/javascript"
		src="resources/js/jquery/jquery-1.9.0.min.js"></script>
	<!-- Bootstrap JS -->
	<script type="text/javascript"
		src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/all.js"></script>
	<script type="text/javascript" src="resources/js/register.js"></script>

</body>
</html>
