<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<base href="<%=basePath%>">
		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8"><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>ExamStack</title>
		<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="keywords" content="">
		<link rel="shortcut icon" href="<%=basePath%>resources/images/favicon.ico" />
		<link href="resources/bootstrap/css/bootstrap-huan.css"
		rel="stylesheet">
		<link href="resources/font-awesome/css/font-awesome.min.css"
		rel="stylesheet">
		<link href="resources/css/style.css" rel="stylesheet">
		
		<style>
			.question-number {
				color: #5cb85c;
				font-weight: bolder;
				display: inline-block;
				width: 30px;
				text-align: center;
			}

			.question-number-2 {
				color: #5bc0de;
				font-weight: bolder;
				display: inline-block;
				width: 30px;
				text-align: center;
			}
			.question-number-3 {
				color: #d9534f;
				font-weight: bolder;
				display: inline-block;
				width: 30px;
				text-align: center;
			}

			a.join-practice-btn {
				margin: 0;
				margin-left: 20px;
			}

			.content ul.question-list-knowledge {
				padding: 8px 20px;
			}

			.knowledge-title {
				background-color: #EEE;
				padding: 2px 10px;
				margin-bottom: 20px;
				cursor: pointer;
				border: 1px solid #FFF;
				border-radius: 4px;
			}

			.knowledge-title-name {
				margin-left: 8px;
			}

			.point-name {
				width: 200px;
				display: inline-block;
			}
			.col-xs-3 {
				width: 22%;
			}
		</style>

	</head>

	<body>
		<header>
			<div class="container">
				<div class="row">
					<div class="col-xs-5">
						<div class="logo">
							<!--<h1><a href="#"><img alt="" src="resources/images/logo.png"></a></h1>-->
						</div>
					</div>
					<div class="col-xs-7" id="login-info">
						<c:choose>
							<c:when test="${not empty sessionScope.user.username}">
								<div id="login-info-user">
									
									<a href="usercenter" id="system-info-account" target="_blank">${sessionScope.user.username}</a>
									<span>|</span>
									<a href="logout"><i class="fa fa-sign-out"></i> 退出</a>
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
				<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="home"><i class="fa fa-home"></i>主页</a>
						</li>
						<li>
							<a href="practice-list"><i class="fa fa-edit"></i>试题练习</a>
						</li>
						<li>
							<a href="exam"><i class="fa  fa-paper-plane-o"></i>在线考试</a>
						</li>
						<li>
							<a href="usercenter"><i class="fa fa-dashboard"></i>个人中心</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>

		<!-- Navigation bar ends -->

		<!-- Slider starts -->

		<div class="full-slider">
			<!-- Slider (Flex Slider) -->

			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="flexslider">
							<div class="flex-caption">
								<!-- Left column -->
								<div class="col-l">
									<p style="text-indent:2em;">
										本系统是一款基于JAVA与MYSQL开发的网络考试系统。它可以稳定、顺畅的运行在Windows与Linux平台上。您可以通过它快捷方便的创建试题和题库，发布试卷，组织考试，系统自动批改。而且具有高度的可配置性和灵活性。
									</p>
									<p style="text-indent:2em;">
										欢迎使用C++在线练习与考试系统。
									</p>
								</div>
								<!-- Right column -->
								<div class="col-r">

									<!-- Use the class "flex-back" to add background inside flex slider -->

									<!-- <img alt="" src="../resources/images/ad.png"> -->
									<p>
										如果您对软件有任何反馈和建议，请联系我们。
									</p>

									<!-- Button -->
									<a class="btn btn-default btn-cta" href="user-register"><i class="fa fa-arrow-circle-down"></i> 联系我们吧</a>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="content" style="padding:30px 0 0 0;">
			<div class="container">
				<div class="row">
					<a class="select-test col-xs-4 home-link-anchor" href="practice-list">
						<div class="select-test-icon">
							<i class="fa fa-book"></i>
	
						</div> <h3> 试题练习 </h3>
						<p>
							您可以免费的进行在线试题的练习，通过在线练习可以考察您的知识掌握程度。
						</p> 
					</a>
					<a class="select-test col-xs-4 home-link-anchor" href="exam">
						<div class="select-test-icon">
							<i class="fa fa-trophy"></i>
						</div> <h3> 在线考试 </h3>
						<p>
							参加教师或者管理员发布的考试，在规定的时间内完成自己的考试
						</p> 
					</a>
					<div class="select-test col-xs-4">
						<div>
							<h3> 快速考试入口 </h3>
							<p>
								直接进入自己最新发布的考试进行相关考试
							</p>

						</div>
						<div style="text-align: center;margin-top:20px;">
							<a class="btn btn-info quick-start-btn" href="quick-start">快速考试入口 <i class="fa fa-arrow-circle-o-right"></i> </a>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="content" style="padding:30px 0 100px 0;">
			<c:if test="${fn:length(newsList) > 0 }">
				<div class="container">
					<div>
						<h3>最新公告</h3>
					</div>
					<div style="margin-top: 20px;">
						<ul class="news-list">
							<c:choose>
								<c:when test="${fn:length(newsList) eq 1 }">
									<li class="news-list-item clearfix">
										<a class="home-link-anchor" href="news/${newsList[0].newsId }" target="_blank">
										<div class="news-list-thumbnail">
											<img src="http://www.examstack.com/resources/images/index/index3.jpg">
										</div>
										<div class="news-list-content">
											<div class="news-list-title">
												${newsList[0].title }
											</div>
											<div class="news-list-creater">
												<i class="fa fa-user"></i><span>${newsList[0].creator }</span>
												<i class="fa fa-clock-o"></i><span><fmt:formatDate value="${newsList[0].createTime }" pattern="yyyy-MM-dd HH:mm"/></span>
											</div>
										</div> </a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="news-list-item clearfix">
										<a class="home-link-anchor" href="news/${newsList[0].newsId }" target="_blank">
										<div class="news-list-thumbnail">
											<img src="http://www.examstack.com/resources/images/index/index3.jpg">
										</div>
										<div class="news-list-content">
											<div class="news-list-title"">
												${newsList[0].title }
											</div>
											<div class="news-list-creater">
												<i class="fa fa-user"></i><span>${newsList[0].creator }</span>
												<i class="fa fa-clock-o"></i><span><fmt:formatDate value="${newsList[0].createTime }" pattern="yyyy-MM-dd HH:mm"/></span>
											</div>
										</div> </a>
									</li>
									<li class="news-list-item clearfix">
										<a class="home-link-anchor" href="news/${newsList[1].newsId }">
										<div class="news-list-thumbnail">
											<img src="http://www.examstack.com/resources/images/index/index2.jpg">
										</div>
										<div class="news-list-content">
											<div class="news-list-title">
												${newsList[1].title }
											</div>
											<div class="news-list-creater">
												<i class="fa fa-user"></i><span>${newsList[1].creator }</span>
												<i class="fa fa-clock-o"></i><span><fmt:formatDate value="${newsList[1].createTime }" pattern="yyyy-MM-dd HH:mm"/></span>
											</div>
										</div> </a>
									</li>
								</c:otherwise>
							</c:choose>
							
							
						</ul>
					</div>
				</div>
			</c:if>
			
		</div>
		<footer>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="copy">
							<p>
								ExamStack Copyright © <a href="http://www.examstack.com/" target="_blank">ExamStack</a> - <a href="." target="_blank">主页</a> | <a href="http://www.examstack.com/" target="_blank">关于我们</a> | <a href="http://www.examstack.com/" target="_blank">FAQ</a> | <a href="http://www.examstack.com/" target="_blank">联系我们</a>
							</p>
						</div>
					</div>
				</div>

			</div>

		</footer>

		<!-- Slider Ends -->

		<!-- Javascript files -->
		<!-- jQuery -->
		<script type="text/javascript"
		src="resources/js/jquery/jquery-1.9.0.min.js"></script>
		<!-- Bootstrap JS -->
		<script type="text/javascript"
		src="resources/bootstrap/js/bootstrap.min.js"></script>
		<script>
		$(function(){
			bindQuestionKnowledage();
			var result = checkBrowser();
			if (!result){
				alert("请至少更新浏览器版本至IE8或以上版本");
			}
		});
		
		function checkBrowser() {
			var browser = navigator.appName;
			var b_version = navigator.appVersion;
			var version = b_version.split(";");
			var trim_Version = version[1].replace(/[ ]/g, "");
			if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE7.0") {
				return false;
			} else if (browser == "Microsoft Internet Explorer"
					&& trim_Version == "MSIE6.0") {
				return false;
			} else
				return true;
		}
		
		function bindQuestionKnowledage(){
			$(".knowledge-title").click(function(){
				var ul = $(this).parent().find(".question-list-knowledge");
				
				if(ul.is(":visible")){
					$(this).find(".fa-chevron-down").hide();
					$(this).find(".fa-chevron-up").show();
					
					$(".question-list-knowledge").slideUp();
					
				}else{
					$(".fa-chevron-down").hide();
					$(".fa-chevron-up").show();
					
					$(this).find(".fa-chevron-up").hide();
					$(this).find(".fa-chevron-down").show();
					
					$(".question-list-knowledge").slideUp();
					ul.slideDown();
					
				}
				
				
			});
		}
		</script>
		<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1252987997'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s19.cnzz.com/z_stat.php%3Fid%3D1252987997' type='text/javascript'%3E%3C/script%3E"));</script>
	</body>
</html>
