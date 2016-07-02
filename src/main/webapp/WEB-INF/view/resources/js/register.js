$(function() {
	create_account.initial();
});

var create_account = {

	initial : function initial() {
		this.bindSubmitForm();
	},

	bindSubmitForm : function bindSubmitForm() {
		$("#btn-reg").click(function() {
			var result = create_account.verifyInput();
			if (result) {
				var data = new Object();
				data.username = $(".form-username input").val();
				data.email = $(".form-email input").val();
				data.password = $(".form-password input").val();
				data.truename = $(".form-truename input").val();
				var action = "user-reg";
				jQuery.ajax({
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					type : "POST",
					url : action,
					data : JSON.stringify(data),
					success : function(message, tst, jqXHR) {
						if (message.success == "true") {
							alert(message.message);
						} else {
							alert(message.message);
						}
					}
				});
			}

			return false;
		});
	},

	verifyInput : function verifyInput() {
		$(".form-message").empty();
		var result = true;
		var check_u = this.checkUsername();
		var check_t = this.checkTrueName();
		var check_e = this.checkEmail();
		var check_p = this.checkPassword();
		var check_pc = this.checkConfirmPassword();
		var check_com = /*this.checkDepartment();*/true;
		
		result = check_u && check_t && check_e && check_p && check_pc && check_com;
		return result;
	},

	//验证用户名
	checkUsername : function checkUsername() {
		//获取表单中用户名的值
		var username = $(".form-username input").val();
		//判断表单是否为空
		if (username == "") {
			//为空时提示用户名不为空
			$(".form-username .form-message").text("用户名不能为空");
			return false;
		} else if (username.length > 20 || username.length < 4) {//判断用户名长度是否在4-20个字符
			//不在范围内给出提示
			$(".form-username .form-message").text("请保持在4-20个字符以内");
			return false;
		} else {
			//判断是否含有非数字字母和下划线的组合
			var re = /[\+|\-|\\|\/||&|!|~|@|#|\$|%|\^|\*|\(|\)|=|\?|´|"|<|>|\.|,|:|;|\]|\[|\{|\}|\|]+/;
			if (re.test(username)) {
				//含有非数字字母和下划线的组合给出提示
				$(".form-username .form-message").text("只能是数字字母或者下划线的组合");
				return false;
			} else
				return true;

		}
		return true;
	},
	checkTrueName : function checkTrueName() {
		var truename = $(".form-truename input").val();
		if (truename == "") {
			$(".form-truename .form-message").text("单位不能为空");
			return false;
		} else if (truename.length > 20 || truename.length < 2) {
			$(".form-truename .form-message").text("请保持在2-20个字符以内");
			return false;
		}
		return true;
	},
	//验证邮箱格式
	checkEmail : function checkEmail() {
		//获取表单中邮箱的值
		var email = $(".form-email input").val();
		//判断邮箱是否为空
		if (email == "") {
			//为空时给出邮箱不为空的提示
			$(".form-email .form-message").text("邮箱不能为空");
			return false;
		} else if (email.length > 60 || email.length < 9) {
			//邮箱的长度不在9-60个字符内给出提示
			$(".form-email .form-message").text("请保持在9-60个字符以内");
			return false;
		} else {
			var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			//如果输入邮箱含有邮箱格式，则判定为正确邮箱，否则为无效邮箱
			if (re.test(email)) {
				return true;
			} else {
				$(".form-email .form-message").text("无效的邮箱");
				return false;
			}

		}
		return true;
	},

	checkPassword : function checkPassword() {
		var password = $(".form-password input").val();
		if (password == "") {
			$(".form-password .form-message").text("密码不能为空");
			return false;
		} else if (password.length < 6 || password.length > 20) {
			$(".form-password .form-message").text("密码请保持在6到20个字符以内");
			return false;
		} else {
			return true;
		}
		return true;
	},
	checkConfirmPassword : function checkConfirmPassword() {
		var password_confirm = $(".form-password-confirm input").val();
		var password = $(".form-password input").val();
		if (password_confirm == "") {
			$(".form-password-confirm .form-message").text("请再输入一次密码");
			return false;
		} else if (password_confirm.length > 20) {
			$(".form-password-confirm .form-message").text(
					"内容过长，请保持在20个字符以内");
			return false;
		} else if (password_confirm != password) {
			$(".form-password-confirm .form-message").text("2次密码输入不一致");
			return false;
		} else {
			return true;
		}
	}
}; 