function Cart() {
	this.save = function() {
		var dataS = {
			"number" : 11,
			"good" : {
				"id" : 1
			}
		};
		$.ajax({
					type : "post",
					url : "http://localhost:8080/mybaites/cart/save",
					data : JSON.stringify(dataS),
					contentType : "application/json;charset=utf-8",
					dataType : "json",
					success : function(data) {
						alert(data);
					},
					error : function() {
					}
				});
	}
	this.list = function() {

		$.ajax({
					type : "get",
					url : "http://localhost:8080/mybaites/cart/cartlist",
					dataType : "json",
					success : function(data) {
						for (var i in data) {
							model(data[i]);
						}
					},
					error : function() {
					}
				});
	}
	var model = function() {
		var model = "<div class=\"eachL\">" + "<div>" + arguments[0].id
				+ "</div>" + "<div>" + arguments[0].number + "</div>" + "<div>"
				+ arguments[0].good.id + "</div>" + "<div>"
				+ arguments[0].good.name + "</div>" + "</div>";
		$("div#listD").append(model);
	}
	this.getbyid = function() {
		$.ajax({
					type : "get",
					url : "http://localhost:8080/mybaites/cart/getbyid?id="
							+ "1",
					dataType : "json",
					success : function(data) {
						$("input#num").val(data.number);
					},
					error : function() {
					}
				});
	}
	this.numberC = function() {
		var dataN = {
			"id" : 1,
			"number" : arguments[0]
		};
		$.ajax({
					type : "post",
					url : "http://localhost:8080/mybaites/cart/update",
					data : JSON.stringify(dataN),
					contentType : "application/json;charset=utf-8",
					dataType : "json",
					success : function(data) {
						if (data == 1) {
							alert("修改成功")
						} else {
							alert("出错啦")
						};
					},
					error : function() {

					}
				});
	}
}

$(document).ready(function() {
			var cart = new Cart();
			$("button#saveB").click(function() {
						cart.save();
					});
			$("button#listB").click(function() {
						cart.list();
					});
			$("button#singleB").click(function() {
						cart.getbyid();
					});
			$("input#num").on("focus", function() {
						this.style.color = "#000000";
					});
			$("button#subB").click(function() {
						var da = $("input#num").val();
						if (isNaN(da)) {
							alert("输入必须为数字！");
						} else {
							cart.numberC(da);
						}
					});

		});