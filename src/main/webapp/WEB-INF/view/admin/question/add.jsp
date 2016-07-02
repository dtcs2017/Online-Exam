<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form id="question_add_form" method="post" action="admin/question/doAdd">
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
                    <input type="text" class="input" id="name" name="name" maxlength="50" value="" data-validate="required:请填写内容" placeholder="请填写试题名称">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="content">试题内容</label>
                    </div>
                    <div class="field">
                    <textarea class="input" id="content" name="content" placeholder="请填写试题内容" rows="10"></textarea>
                    </div>
                    </div>
                    <div class="form-group"><div class="label">
                    <label for="points">选项A</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="optionA" maxlength="50" value="" data-validate="required:请填写选项A" placeholder="请填写选项A">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">选项B</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="optionB" maxlength="50" value="" data-validate="required:请填写选项B" placeholder="请填写选项B">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">选项C</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="optionC" maxlength="50" value="" data-validate="required:请填写选项C" placeholder="请填写选项C">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">选项D</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="optionD" maxlength="50" value="" data-validate="required:请填写选项D" placeholder="请填写选项D">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="points">试题分值</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" id="points" name="points" maxlength="50" value="" data-validate="required:请填写数字,plusinteger:请输入不含0和负数的数字,length#<5:字数在5个" placeholder="请填写试题分值">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label for="answer">试题答案</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" id="answer" name="answer" maxlength="50" value="" data-validate="required:请填写内容" placeholder="请填写试题答案">
                    </div>
                    </div>
                    <div class="form-group"><div class="label">
                    <label for="content">试题解析</label>
                    </div>
                    <div class="field">
                    <textarea class="input" name="analysis" placeholder="请填写试题解析" rows="10"></textarea>
                    </div>
                    </div>
                    <div class="form-group">
                    <input class="button bg-red" type="submit" value="确认">&nbsp;&nbsp;&nbsp;&nbsp;<button class="button bg-yellow form-reset type=" reset="" "="">重设</button>
                    </div>
                    </form>