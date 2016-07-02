<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form id="group_add_form" method="post" action="admin/user/groupupdate">
                    <div class="form-group"><div class="label">
                    <label> 组名</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="groupName" maxlength="50" value="" data-validate="required:请填写内容" placeholder="请填写用户组名">
                            </div>
                            </div>
                    <div class="form-group">
                    <input class="button bg-red" type="submit" value="下一步">&nbsp;&nbsp;&nbsp;&nbsp;<button class="button bg-yellow form-reset" type="reset">重设</button>
                    </div>
                    </form>