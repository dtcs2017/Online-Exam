<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
		<title>在线题库系统-后台管理</title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="stylesheet" href="css/layer.css">
		<link rel="stylesheet" href="css/layer.ext.css">
		<script src="js/jquery.js"></script>
		<script src="js/ajaxForm.js"></script>
		<script src="js/pintuer.js"></script>
		<script src="js/admin.js"></script>
		<link type="image/x-icon" href="http://www.pintuer.com/favicon.ico" rel="shortcut icon" />
		<link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
		<style>
		.nodisplay{display:none;}
		</style>
	</head>

	<body>
		<div class="lefter">
			<div class="logo">
				<a href="http://www.pintuer.com" target="_blank"><img src="images/logo.png" alt="后台管理系统" /></a>
			</div>
		</div>
		<div class="righter nav-navicon" id="admin-nav">
			<div class="mainer">
				<div class="admin-navbar">
					<span class="float-right">
                    <a class="button button-little bg-main" href="http://www.pintuer.com" target="_blank">前台首页</a>
                    <a class="button button-little bg-yellow" href="login.html">注销登录</a>
                </span>
					<ul class="nav nav-inline admin-nav">
						<li>
							<a href="admin/index" class="icon-home"> 开始</a>
							<ul>
								<li><a href="system.html">系统设置</a></li>
								<li><a href="admin/question/index">试题管理</a></li>
								<li><a href="admin/exampaper/index">试卷管理</a></li>
								<li><a href="admin/exam/index">考试管理</a></li>
								<li><a href="admin/user/index">用户管理</a></li>
								<li><a href="#">统计管理</a></li>
							</ul>
						</li>
						<li>
							<a href="system.html" class="icon-cog"> 系统</a>
							<ul>
								<li><a href="#">系统公告</a></li>
								<li class="active"><a href="#">登录日志</a></li>
								<li><a href="#">管理员列表</a></li>
							</ul>
						</li>
						<li class="active">
							<a href="admin/question/index" class="icon-file-text"> 试题</a>
							<ul>
								<li class="active"><a href="#">录入试题</a></li>
							</ul>
						</li>
						<li><a href="admin/exampaper/index" class="icon-shopping-cart"> 试卷</a>
						    <ul>
								<li><a href="exampaper/index">创建试卷</a></li>
							</ul>
						</li>
						<li><a href="admin/exam/index" class="icon-user"> 考试</a>
						    <ul>
								<li><a href="#">发布考试</a></li>
							</ul>
						</li>
						<li><a href="admin/user/index" class="icon-user"> 用户</a>
						    <ul>
								<li><a href="#">教师管理</a></li>
								<li><a href="#">学生管理</a></li>
							</ul>
						</li>
						<li><a href="#" class="icon-user"> 统计</a>
						    <ul>
								<li><a href="#">统计图表</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="admin-bread">
					<span>您好，admin，欢迎您的光临。</span>
					<ul class="bread">
						<li><a href="index.html" class="icon-home"> 开始</a></li>
						<li>后台首页</li>
					</ul>
				</div>
			</div>
		</div>
<div class="admin">
    <form id="question_update_form" method="post" action="doUpdate">
                    <input type="hidden" name="id" value="${question.id}">
                    <div class="form-group"><div class="label">
                    <label for="type"> 试题类型</label>
                    </div>
                    <div class="field">
                     <select class="input" id="questiontypeId" name="questiontypeId" data-validate="required:请选择,length#>=1:至少选择1项">
                            <c:forEach items="${questionTypeList}" var="x">
                            <option value="${x.id}">${x.type}</option>
                         </c:forEach>
                            </select>
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="name">试题名称</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" id="name" name="name" maxlength="50" value="${question.name}" data-validate="required:请填写内容" placeholder="请填写试题名称">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="content">试题内容</label>
                    </div>
                    <div class="field">
                    <textarea class="input" id="content" name="content" placeholder="请填写试题内容" rows="10">${question.content}</textarea>
                    </div>
                    </div>
                    <div class="form-group"><div class="label">
                    <label for="points">选项A</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="optionA" maxlength="50" value="${question.optionA}" data-validate="请填写选项A" placeholder="请填写选项A">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">选项B</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="optionB" maxlength="50" value="${question.optionB}" data-validate="请填写选项B" placeholder="请填写选项B">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">选项C</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="optionC" maxlength="50" value="${question.optionC}" data-validate="required:请填写选项C" placeholder="请填写选项C">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">选项D</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="optionD" maxlength="50" value="${question.optionD}" data-validate="required:请填写选项D" placeholder="请填写选项D">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">试题分值</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" id="points" name="points" maxlength="50" value="${question.points}" data-validate="required:请填写数字,plusinteger:请输入不含0和负数的数字,length#<5:字数在5个" placeholder="请填写试题分值">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="answer">试题答案</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" id="answer" name="answer" maxlength="50" value="${question.answer}" data-validate="required:请填写内容" placeholder="请填写试题答案">
                    </div>
                    </div>
                    <div class="form-group">
                    <input class="button bg-red" type="submit" value="确认">&nbsp;&nbsp;&nbsp;&nbsp;<button class="button bg-yellow form-reset type=" reset="" "="">重设</button>
                    </div>
                    </form>
                    </div>
<div class="hidden">
			<script>
			//调用
		    $(document).ready(function(){
				$('#question_update_form').bind('submit', function(){
					ajaxSubmit(this, function(data){
						alert(data.message);
						window.location.href="admin/question/index";
					});
					return false;
				});
		    });
			</script>
		</div>
	</body>

</html>