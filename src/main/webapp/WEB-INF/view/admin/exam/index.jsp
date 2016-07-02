<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		<link rel="stylesheet" href="css/jquery-ui.css">
		<link rel="stylesheet" href="css/jquery-ui-timepicker-addon.min.css" /> 
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.min.js"></script>
		<script src="js/pintuer.js"></script>
		<script src="js/admin.js"></script>
		<script src="js/jquery-ui-timepicker-addon.min.js"></script>
		<script src="js/jquery-ui-timepicker-addon.js"></script>  
        <script src="js/jquery-ui-timepicker-zh-CN.js"></script> 
		<link type="image/x-icon" href="http://www.pintuer.com/favicon.ico" rel="shortcut icon" />
		<link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
		<style>
		.nodisplay{display:none;}
		.my_input{border: solid 1px #ddd;border-radius: 4px;}
		.my_td{width:250px;}
		
		.ui-timepicker-div .ui-widget-header { margin-bottom: 8px; }
        .ui-timepicker-div dl { text-align: left; }
        .ui-timepicker-div dl dt { height: 25px; margin-bottom: -25px; }
        .ui-timepicker-div dl dd { margin: 0 10px 10px 65px; }
        .ui-timepicker-div td { font-size: 90%; }
        .ui-tpicker-grid-label { background: none; border: none; margin: 0; padding: 0; }
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
						<li>
							<a href="admin/question/index" class="icon-file-text"> 试题</a>
							<ul>
								<li><a href="#">录入试题</a></li>
							</ul>
						</li>
						<li>
						   <a href="admin/exampaper/index" class="icon-shopping-cart"> 试卷</a>
						    <ul>
								<li><a href="#">创建试卷</a></li>
							</ul>
						</li>
						<li class="active">
						<a href="admin/exam/index" class="icon-user"> 考试</a>
						    <ul>
								<li class="active"><a href="#">发布考试</a></li>
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
			<form method="post">
				<div class="panel admin-panel">
					<div class="panel-head"><strong>试题列表</strong></div>
					<div class="padding border-bottom">
					<form method="post" action="exam/index">
					<table>
					<tr>
					<td class="my_td">考试名称:<input type="text" name="name" class="my_input">  </td>
                    <td class="my_td"><input type="submit" class="button bg-sub" value="检索"></td>
					</tr>
					</table>
					</form>
					</div>
					<div class="padding border-bottom">
						<input type="button" class="button button-small checkall" name="checkall" checkfor="id" value="全选" />
						<input type="button" id="create_exam" class="button button-small border-green" value="发布考试" />
						<input type="button" class="button button-small border-yellow" value="批量删除" />
						<input type="button" class="button button-small border-blue" value="回收站" />
						
				</div>
					<table class="table table-hover">
						<tr>
							<th width="45">选择</th>
							<th width="30">id</th>
							<th width="120">考试名称</th>
							<th width="120">试卷名称</th>
							<th width="50">用户组</th>
							<th width="100">开始时间</th>
							<th width="100">结束时间</th>
							<th width="150">创建时间</th>
							<th width="100">操作</th>
						</tr>
						<c:forEach items="${pageBean.thisPageElements}" var="x">
						<tr>
							<td>
								<input type="checkbox" name="id" value="1" />
							</td>
							<td>${x.id}</td>
							<td>${x.examName}</td>
							<td>${x.paperName}</td>
							<td>${x.groupName}</td>
							<td><fmt:formatDate value="${x.startTime}" type="both"/></td>
							<td><fmt:formatDate value="${x.endTime}" type="both"/></td>
							<td><fmt:formatDate value="${x.createTime}" type="both"/></td>
							<td><a class="button border-blue button-little" href="exam/update?id=${x.id}">修改</a> <a class="button border-yellow button-little" style="cursor:pointer;" onclick="doDelete(${x.id})">删除</a></td>
						</tr>
						</c:forEach>
					</table>
					<div class="panel-foot text-center">
				    <ul class="pagination">
				    <li style="border:0;">共${pageBean.totalNumberOfElements}条  ${pageBean.thisPageNumber}/${pageBean.lastPageNumber}页  &nbsp;&nbsp;</li>
					<c:if test="${pageBean.thisPageNumber==1}">
					<li><a href="admin/exam/index?pageNum=${pageBean.thisPageNumber+1}">下一页</a></li>
					<li><a href="admin/exam/index?pageNum=${pageBean.lastPageNumber}">尾页</a></li>
					</c:if>
					<c:if test="${pageBean.thisPageNumber>1 && (pageBean.thisPageNumber<pageBean.lastPageNumber)}">
					<li><a href="admin/exam/index?pageNum=1">首页</a></li>
					<li><a href="admin/exam/index?pageNum=${pageBean.thisPageNumber-1}">上一页</a></li>
					<li><a href="admin/exam/index?pageNum=${pageBean.thisPageNumber+1}">下一页</a></li>
					<li><a href="admin/exam/index?pageNumr=${pageBean.lastPageNumber}">尾页</a></li>
					</c:if>			
					<c:if test="${pageBean.thisPageNumber == pageBean.lastPageNumber}">
					<li><a href="admin/exam/index?pageNum=1">首页</a></li>
					<li><a href="admin/exam/index?pageNum=${pageBean.thisPageNumber-1}">上一页</a></li>
					</c:if>
					</ul>
					
					</div>
				</div>
			</form>
			<br />
			<p class="text-right text-gray">基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建</p>
		</div>
		
		
		<!-- 添加 -->
		<div class="hidden" id="exam_form" style="padding:20px;">
		<%@ include file="add.jsp" %>
		</div>
		<!-- 修改 -->
		<div class="hidden" id="exam_form" style="padding:20px;">
		
		</div>

		<div class="hidden">
			
			<script src="js/layer.js"></script>
			<script>
			//添加弹出层
			$("#create_exam").on('click', function(){
				layer.open({
                    type: 1,
                    title: "发布考试",
                    area: ['600px', '400px'],
                    skin: 'layui-layer-rim', //加上边框
                    content: $('#exam_form'),
                    success: function(){
                    	$('#exam_form').removeClass("hidden");
                    },
                    cancel: function(index){
                    	$('#exam_form').addClass("hidden");
                    	layer.closeAll();
                    }
                });
			});
			
			//修改弹出层
			/*$("#update_exam").on('click', function(){
				layer.open({
                    type: 2,
                    area: ['900px', '500px'],
                    skin: 'layui-layer-rim', //加上边框
                    content: 'update.jsp'
                   
                });
			});*/
	
			//将form转为AJAX提交
			function ajaxSubmit(frm, fn) {
			    var dataPara = getFormJson(frm);
			    $.ajax({
			        url: frm.action,
			        type: frm.method,
			        data: dataPara,
			        success: fn
			    });
			}
			//将form中的值转换为键值对。
			function getFormJson(frm) {
			    var o = {};
			    var a = $(frm).serializeArray();
			    $.each(a, function () {
			        if (o[this.name] !== undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            o[this.name].push(this.value || '');
			        } else {
			            o[this.name] = this.value || '';
			        }
			    });

			    return o;
			}
			
			//调用
		    $(document).ready(function(){
				$('#exam_add_form').bind('submit', function(){
					ajaxSubmit(this, function(data){
						alert(data.message);
						window.location.href="admin/exam/index";
					});
					return false;
				});
		    });
			
			function doDelete(id1){
				if(confirm('确认删除?')){
							$.ajax({
						        url: "admin/exam/doDelete.action",
						        type: "post",
						        data: {id:id1},
						        success: function(data){
						        	alert(data.message);
						        	window.location.href="admin/exam/index";
						        }
						    });
					return true;
					}
				return false;
			}
			</script>
			
			<script>
			
			$('#startTime').datetimepicker({
				dateFormat: "yy-mm-dd",
				onClose: function( selectedDate ) {
			        $( "#endTime" ).datepicker( "option", "minDate", selectedDate );
			      }
			}); // 日期+时分秒 
			$('#endTime').datetimepicker({
				dateFormat: "yy-mm-dd",
				onClose: function( selectedDate ) {
			        $( "#startTime" ).datepicker( "option", "maxDate", selectedDate );
			      }
			}); // 日期+时分秒  
		
		//$('#startTime').datepicker(); // 日期  
		//$('#startTime').timepicker(); // 时分秒
		</script>
		</div>
	</body>

</html>