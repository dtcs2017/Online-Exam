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
						<li>
							<a href="admin/question/index" class="icon-file-text"> 试题</a>
							<ul>
								<li><a href="#">录入试题</a></li>
							</ul>
						</li>
						<li><a href="admin/exampaper/index" class="icon-shopping-cart"> 试卷</a>
						    <ul>
								<li><a href="#">创建试卷</a></li>
								<li><a href="#">修改试卷</a></li>
							</ul>
						</li>
						<li><a href="admin/exam/index" class="icon-user"> 考试</a>
						    <ul>
								<li><a href="#">发布考试</a></li>
							</ul>
						</li>
						<li class="active"><a href="admin/user/index" class="icon-user"> 用户</a>
						    <ul>
								<li><a href="#">教师管理</a></li>
								<li><a href="#">学生管理</a></li>
								<li class="active"><a href="user/group">用户组</a>
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
    <input type="hidden" id="groupname" value="${group.groupName}">
				<div class="panel admin-panel">
					<div class="panel-head"><strong>用户组列表</strong></div>
					
					<table class="table table-hover" id="content">
						
						
					</table>
					<div class="panel-foot text-center" id="pager">
				    
					
					</div>
				</div>
			</form>
			<div><input type="button" class="button bg-blue" value="添加选中" onclick="doUpdate()"></div>
                    </div>
<div class="hidden">
			<script>
			//调用
		    $(document).ready(function(){
				$('#group_update_form').bind('submit', function(){
					ajaxSubmit(this, function(data){
						alert(data.message);
						window.location.href="admin/user/group";
					});
					return false;
				});
		    });
			</script>
			
			<script>
			var checkedIds="";//翻页保存选中的id
			
			 $(function () {

		            $.post("admin/user/userlist.action", null, function (data) {

		                var total = data;
		                var pageS = data.lastPageNumber;
		                var pageIndex = data.thisPageNumber;
		                PageClick(pageIndex, total, pageS, 3);
		            });

		            PageClick = function (pageIndex, total, pageS, spanInterval) {
		                $.ajax({
		                    url: "admin/user/userlist.action",
		                    data: { "pageNum": pageIndex },
		                    type: "post",
		                    dataType: "json",
		                    beforeSend: function(){
		                    	changeIds();
		                    },
		                    success: function (data) {
		                        //索引从1开始
		                        //将当前页索引转为int类型
		                        var intPageIndex = parseInt(pageIndex);

		                        //获取显示数据的表格
		                        var table = $("#content");
		                        //清楚表格中内容
		                        $("#content tr").remove();
		                        
		                        //table.append("<th>选择</th><th>id</th><th>试卷名称</th><th>试卷类型</th><th>分值</th>");

		                        //向表格中添加内容
		for (var i =0; i < data.thisPageElements.length; i++) {
		                            table.append(
		                                $("<tr><td>"+
		                                "<input type='checkbox' name='id' value="+data.thisPageElements[i].id+" />"
		 		                        +"</td><td>"+
		                                data.thisPageElements[i].id
		                                +"</td><td>"+
		                                data.thisPageElements[i].username
		                                +"</td><td>"+
		                                data.thisPageElements[i].truename
		                                +"</td><td>"+
		                                data.thisPageElements[i].email
		                                +"</td></tr>")
		                                );
		                        } //for

		                        //创建分页
		                        //将总记录数结果 得到 总页码数
		                        /*var pageS = total
		                        if (pageS %10==0) pageS = pageS /10;
		                        else pageS = parseInt(total /10) +1;*/
		                        var $pager = $("#pager");

		                        //清楚分页div中的内容
		                        $("#pager span").remove();
		                        $("#pager a").remove();

		                        //添加第一页
		if (intPageIndex ==1)
		                            $pager.append("<span class='disabled'>第一页</span>");
		                        else {
		                            var first = $("<a href='javascript:void(0)' first='"+1+"'>第一页</a>").click(function () {
		                                PageClick($(this).attr('first'), total, pageS, spanInterval);
		                                return false;
		                            });
		                            $pager.append(first);
		                        }


		                        //添加上一页
		if (intPageIndex ==1)
		                            $pager.append("<span class='disabled'>上一页</span>");
		                        else {
		                            var pre = $("<a href='javascript:void(0)' pre='"+ (intPageIndex -1) +"'>上一页</a>").click(function () {
		                                PageClick($(this).attr('pre'), total, pageS, spanInterval);
		                                return false;
		                            });
		                            $pager.append(pre);
		                        }

		                        //设置分页的格式  这里可以根据需求完成自己想要的结果
		                        var interval = parseInt(spanInterval); //设置间隔
		                        var start = Math.max(1, intPageIndex - interval); //设置起始页
		                        var end = Math.min(intPageIndex + interval, pageS)//设置末页

		                        if (intPageIndex < interval +1) {
		                            end = (2* interval +1) > pageS ? pageS : (2* interval +1);
		                        }

		                        if ((intPageIndex + interval) > pageS) {
		                            start = (pageS -2* interval) <1?1 : (pageS -2* interval);

		                        }


		                        //生成页码
		for (var j = start; j < end +1; j++) {
		                            if (j == intPageIndex) {
		                                var spanSelectd = $("<span class='current'>"+ j +"</span>");
		                                $pager.append(spanSelectd);
		                            } //if 
		else {
		                                var a = $("<a href='javascript:void(0)' style='padding:5px;'>" +j +"</a>").click(function () {
		                                    PageClick($(this).text(), total, pageS, spanInterval);
		                                    return false;
		                                });
		                                $pager.append(a);
		                            } //else
		                        } //for

		                        //上一页
		if (intPageIndex == total) {
		                            $pager.append("<span class='disabled'>下一页</span>");

		                        }
		                        else {

		                            var next = $("<a href='javascript:void(0)' next='"+ (intPageIndex +1) +"'>下一页</a>").click(function () {
		                                PageClick($(this).attr("next"), total, pageS, spanInterval);
		                                return false;
		                            });
		                            $pager.append(next);
		                        }

		                        //最后一页
		if (intPageIndex == pageS) {
		                            $pager.append("<span class='disabled'>最后一页</span>");

		                        }
		                        else {
		                            var last = $("<a href='javascript:void(0)' last='"+ pageS +"'>最后一页</a>").click(function () {
		                                PageClick($(this).attr("last"), total, pageS, spanInterval);
		                                return false;
		                            });
		                            $pager.append(last);
		                        }
		                        
		getChecked();

		                    } //sucess

		                }); //ajax

		            }; //function

		        });   //ready
			
		        
		        function changeIds(){
		             var oneches=document.getElementsByName("id");
		             for(var i=0;i<oneches.length;i++){
		                 if(oneches[i].checked==true){
		                     //避免重复累计id （不含该id时进行累加）
		                     if(checkedIds.indexOf(oneches[i].value)==-1){
		                         checkedIds=checkedIds+oneches[i].value+",";
		                     }
		                 }
		                 if(oneches[i].checked==false){
		                     //取消复选框时 含有该id时将id从全局变量中去除
		                     if(checkedIds.indexOf(oneches[i].value)!=-1){
		                         checkedIds=checkedIds.replace((oneches[i].value+","),"");
		                     }
		                 }
		             }
		             console.log(checkedIds);
		          }
		     
		       function getChecked(){
		                var oneches=document.getElementsByName("id");
		             for(var i=0;i<oneches.length;i++){
		                     //全局变量中含有id，则该复选框选中
		                     if(checkedIds.indexOf(oneches[i].value)!=-1){
		                         oneches[i].checked=true;
		                     }
		                 }
		          }
		       
		       function doUpdate(){
		    	   changeIds();
		    	   var groupName = $('#groupname').val();
		    	   var userids = checkedIds;
		    	   $.ajax({
	                    url: "admin/user/groupdoUpdate.action",
	                    data: { "groupName": groupName, "userids": userids },
	                    type: "post",
	                    dataType: "json",
	                    success: function (data) {
	                    	alert("添加成功！");
	                    }
		    	   });
		       }
			</script>
			
			<script>
			
		      
	          
			</script>
		</div>
	</body>

</html>