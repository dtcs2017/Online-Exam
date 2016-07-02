<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form id="exam_add_form" method="post" action="admin/exam/doAdd">
                    <div class="form-group"><div class="label">
                    <label for="name">考试名称</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="examName" maxlength="50" value="" data-validate="required:请填写内容" placeholder="请填写试卷名称">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="type"> 选择试卷</label>
                    </div>
                    <div class="field">
                     <select class="input" name="examPaperid" data-validate="required:请选择,length#>=1:至少选择1项">
                            <c:forEach items="${examPaperList}" var="x">
                            <option value="${x.id}">${x.paperName}</option>
                         </c:forEach>
                            </select>
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="type"> 选择用户组</label>
                    </div>
                    <div class="field">
                     <select class="input" name="groupId" data-validate="required:请选择,length#>=1:至少选择1项">
                            <c:forEach items="${groupList}" var="x">
                            <option value="${x.id}">${x.groupName}</option>
                         </c:forEach>
                            </select>
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">开始时间</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" id="startTime" name="startTime" placeholder="选择日期时间" >
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">结束时间</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" id="endTime" name="endTime" maxlength="50" value="" placeholder="选择日期时间" >
                            </div>
                            </div>
                  、
                    <div class="form-group">
                    <input class="button bg-red" type="submit" value="确认">&nbsp;&nbsp;&nbsp;&nbsp;<button class="button bg-yellow form-reset type=" reset="" "="">重设</button>
                    </div>
                    </form>