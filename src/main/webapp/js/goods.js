$(document).ready(function() {
	var good = new Goods();
	// 商品上传（只做了数字检验，因为不检验，非数字后台报错，string为""不会报错）
	$("button#sub").click(function() {
				var name = $(this).parent().find("input").eq(0).val();
				var price = $(this).parent().find("input").eq(1).val();
				var numberStore = $(this).parent().find("input").eq(2).val();
				var provider = $(this).parent().find("input").eq(3).val();

				if (good.check(price) == "数字"
						&& good.check(numberStore) == "数字") {
					good.save(name, price, numberStore, provider);
				} else {
					alert("价格和数量必须为数字");
				}
			});

	// 商品列表
	$("button#showL").click(function() {
				good.goodsList();
			});

	// 商品的详细
	$("button#oneS").click(function() {
				var id = 1;
				// 需要提供id
				good.showOne(id);
			});
	function Goods() {
		this.check = function() {
			var param = arguments[0];
			if (!isNaN(param)) {
				return "数字";
			} else if (param == "") {
				return "内容为空";
			} else {
				return "ok";
			}
		}
		this.save = function() {
			var dataS = {
				"name" : arguments[0],
				"price" : arguments[1],
				"numberStore" : arguments[2],
				"provider" : arguments[3]
			};
			$.ajax({
						type : "post",
						url : "http://localhost:8080/mybaites/goods/save",
						data : JSON.stringify(dataS),
						contentType : "application/json;charset=utf-8",
						dataType : "json",
						success : function(data) {
							alert(data);
						},
						error : function(xhr, status) {
							alert(xhr);
						}
					});
		}
		this.goodsList = function() {
			$.ajax({
						type : "get",
						url : "http://localhost:8080/mybaites/goods/selectall",
						dataType : "json",
						success : function(data) {
							for (var i in data) {
								M(data[i].id, data[i].name, data[i].price);
							}
						},
						error : function() {
						}
					});
		}
		this.showOne = function() {
			$.ajax({
						type : "get",
						url : "http://localhost:8080/mybaites/goods/showdetail?id="
								+ arguments[0],
						dataType : "json",
						success : function(data) {
							O(data.id, data.name, data.price, data.numberStore,
									data.provider);
						},
						error : function() {
						}
					});
		}
	}
	function M() {
		var model = "<div class=\"showItem\">" + "<span class=\"diff_f\">"
				+ arguments[0] + "</span>" + "<span class=\"diff_s\">"
				+ arguments[1] + "</span>" + "<span class=\"diff_f\">"
				+ arguments[2] + "</span>" + "</div>";
		$("div#showList").append(model);
	}
	function O() {
		var model = "<div class=\"item\">" + "<div>" + arguments[0] + "</div>"
				+ "<div>" + arguments[1] + "</div>" + "<div>" + arguments[2]
				+ "</div>" + "<div>" + arguments[3] + "</div>" + "<div>"
				+ arguments[4] + "</div>" + "</div>";
		$("div#showOne").append(model);
	}
});