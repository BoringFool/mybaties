<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/jquery-min.js"></script>
<script type="text/javascript" src="../js/cart.js"></script>
<link href="../css/cart.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<button id="saveB" class="savesClass" type="button">保存提交,调用保存功能,仅演示功能</button>
	<button id="listB" class="savesClass" type="button">查询cart列表</button>
	<button id="singleB" class="savesClass" type="button">先查数量查出来，再修改提交（id：1）</button>
	<input id="num" class="changeD"  type="text" value="先点击左边查"/>
	<button id="subB" class="savesClass" type="button">修改购买数量，点这里提交</button>
	<div id="listD">
		<h6 style="width: 120px;margin: 0 auto;">多次点击会重复查询，查询前需先添加</h6>
		<div class="eachL">
			<div>id</div>
			<div>number</div>
			<div>goods.id</div>
			<div>goods.name</div>
		</div>

	</div>
</body>
</html>