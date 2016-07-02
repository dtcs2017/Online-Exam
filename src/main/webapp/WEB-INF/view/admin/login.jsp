﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
	<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>拼图后台管理-管理员登录</title>
		<link rel="stylesheet" href="css/pintuer.css">
		<script src="js/jquery.js"></script>
		<script src="js/pintuer.js"></script>
		<link type="image/x-icon" href="http://www.pintuer.com/favicon.ico" rel="shortcut icon" />
		<link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
	</head>

	<body>
		<div class="container">
			<div class="line">
				<div class="xs6 xm4 xs3-move xm4-move">
					<br />
					<br />
					<div class="media media-y">
						<a href="http://www.pintuer.com" target="_blank"><img src="images/logo.png" class="radius" alt="后台管理系统" /></a>
					</div>
					<br />
					<br />
					<form action="admin/checklogin" method="post">
						<div class="panel">
							<div class="panel-head"><strong>登录后台管理系统</strong></div>
							<div class="panel-body" style="padding:30px;">
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="text" class="input" name="username" placeholder="登录账号" data-validate="required:请填写账号,length#>=4:账号长度不符合要求" />
										<span class="icon icon-user"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="field field-icon-right">
										<input type="password" class="input" name="password" placeholder="登录密码" data-validate="required:请填写密码,length#>=4:密码长度不符合要求" />
										<span class="icon icon-key"></span>
									</div>
								</div>
								<!-- <div class="form-group">
									<div class="field">
										<input type="text" class="input" name="passcode" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
										<img src="images/passcode.jpg" width="80" height="32" class="passcode" />
									</div>
								</div>-->
							</div>
							<div class="panel-foot text-center">
								<button class="button button-block bg-main text-big">立即登录后台</button>
							</div>
						</div>
					</form>
					<div class="text-right text-small text-gray padding-top">基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建</div>
				</div>
			</div>
		</div>

		<div class="hidden">
			<script src="http://s4.cnzz.com/stat.php?id=5952475&web_id=5952475" language="JavaScript"></script>
			<script>
				var _hmt = _hmt || [];
				(function() {
					var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
					document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F637f0fe043ea4b7f59c05d4491e27667' type='text/javascript'%3E%3C/script%3E"));
				})();
			</script>
		</div>
	</body>

</html>