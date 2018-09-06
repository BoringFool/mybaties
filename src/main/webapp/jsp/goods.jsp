<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/jquery-min.js"></script>
<script type="text/javascript" src="../js/goods.js"></script>
<link href="../css/goods.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<div class="outer">
		name of goods:<input id="name" type="text"> price:<input
			id="price" type="text"> numberStore: <input id="numberStore"
			type="text"> provider:<input id="provider" type="text">
		<input type="hidden">
		<button id="sub" class="subButton" type="button">上传</button>
	</div>
	<div id="showList" class="outer">
		<div style="width: 280px; height: 30px;">
			<button id="showL" type="button">展示商品列表</button>
		</div>
		<div class="showItem">
			<span class="diff_f">id</span><span class="diff_s">name</span><span class="diff_f">price</span>
		</div>
	</div>
	<div id="showOne" class="outer">
		<h5>需要查询列表时，添加一个隐藏域来保存过的是的id。这里默认查询id为1</h5>
		<button id="oneS" type="button">商品详细</button>
		
	</div>
</body>
</html>