<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form id="user_add_form" method="post" action="admin/user/doAdd">
                    <div class="form-group"><div class="label">
                    <label> 用户名</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="username" maxlength="50" value="" data-validate="required:请填写内容" placeholder="请填写用户名">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label>真实姓名</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="truename" maxlength="50" value="" data-validate="required:请填写内容" placeholder="请填写真实姓名">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label>性别</label>
                    </div>
                    <div class="field">
                    <div class="button-group radio">
                      <label class="button">
                        <input name="gender" value="0" type="radio" data-validate="required:选择性别,radio:请选择性别">男
                      </label>
                      <label class="button">
                        <input name="gender" value="1" type="radio" data-validate="required:选择性别,radio:请选择性别">女
                      </label>
                     </div>
                            </div>
                            </div>  
                    <div class="form-group"><div class="label">
                    <label>邮箱</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="email" maxlength="50" value="" data-validate="required:请填写邮箱,email:请输入邮箱" placeholder="请填写电子邮箱">
                    </div>
                    </div>
                    <div class="form-group"><div class="label">
                    <label>密码</label>
                    </div>
                    <div class="field">
                    <input type="password" class="input" name="password" maxlength="50" value="" data-validate="required:请填写密码" placeholder="请填写密码">
                    </div>
                    </div>
                    <div class="form-group"><div class="label">
                    <label>年龄</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="age" maxlength="50" value="" data-validate="required:请填写年龄,plusinteger:请输入不含0和负数的数字" placeholder="请填写年龄">
                            </div>
                            </div>
                    <div class="form-group">
                    <input class="button bg-red" type="submit" value="确认">&nbsp;&nbsp;&nbsp;&nbsp;<button class="button bg-yellow form-reset" type="reset">重设</button>
                    </div>
                    </form>