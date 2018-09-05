$(document).ready(function() {
	var user = new User();
	var nameOk = false;
	// 注册
	$("button#sub").click(function() {
				var userName = $("input#username").val();
				var age = $("input#age").val();
				var password = $("input#password").val();
				user.register(userName, age, password);
			});

	// Ajax校验用户名
	$("input#username").on("change", function() {
				var text = this.value;
				if (text == "") {
					this.style.background = "none";
				} else {
					user.check(text, this);
				}
			});

	// 登录
	$("button#subL").click(function() {
				alert("ok");
				var userName = $("input#usernameL").val();
				var password = $("input#passwordL").val();
				if (nameOk == true) {
					//用来判断用户名是否存在，因为不同div，所以后端做了用户名验证
				}
				user.login(userName, password);
			});

	function User() {
		this.check = function() {
			// 直接调用报错，要赋值给$this调用
			var $this = arguments[1];
			var adress = "http://localhost:8080/mybaites/user/checkName?username="
					+ arguments[0];
			$.ajax({
						type : "get",
						url : adress,
						dataType : "json",
						success : function(data) {
							if (data == 1) {
								$this.style.background = "#ff6f6f";
							} else {
								$this.style.background = "#00f200";
								nameOk = true;
							}
						},
						error : function(xhr, status) {
							alert(xhr);
						}
					});

		}
		this.register = function() {
			var dataR = {
				"username" : arguments[0],
				"age" : arguments[1],
				"password" : arguments[2]
			};
			$.ajax({
						type : "post",
						url : "http://localhost:8080/mybaites/user/register",
						data : JSON.stringify(dataR),
						contentType : "application/json;charset=utf-8",
						dataType : "json",
						success : function(data) {
							if (data == 1) {
								alert("注册成功！");
							} else if (data = -1) {
								alert("用户已经存在！");
							} else {
								alert("注册失败!");
							}
						},
						error : function(xhr, status) {
							alert(xhr);
							alert(status);
						}
					});
		}
		this.login = function() {
			var dataL = {
				"username" : arguments[0],
				"password" : arguments[1]
			};
			$.ajax({
						type : "post",
						url : "http://localhost:8080/mybaites/user/login",
						data : JSON.stringify(dataL),
						contentType : "application/json;charset=utf-8",
						dataType : "json",
						success : function(data) {
							if (data == 1) {
								alert("登陆成功");
							} else if (data == -1) {
								alert("用户不存在");
							} else {
								alert("登陆失败，密码错误");
							}
						},
						error : function(xhr, status) {
							alert(xhr);
						}
					});
		}
	}
});