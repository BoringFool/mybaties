<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/jquery-min.js"></script>
<script type="text/javascript" src="../js/user.js"></script>
<link rel="stylesheet" type="text/css" href="../css/user.css">
<title>Insert title here</title>
<script>
	var name="${sessionScope.username}";
</script>
</head>
<body>
	<div class="outer">
		<div>
			UserName:<input id="username" type="text" />
		</div>
		<div>
			Age:<input id="age" type="text" />
		</div>
		<div>
			Password:<input id="password" type="password" />
		</div>
		<div>
			<button id="sub" class="s" type="button">注册</button>
		</div>
	</div>
	<div class="outer">
		<div>
			UserName:<input id="usernameL" type="text" />
		</div>
		<div>
			Password:<input id="passwordL" type="password" />
		</div>
		<div>
			<button id="subL" class="s" type="button">登陆</button>
		</div>
		<div id="nameSpace" style="width:400px;height:25px;text-align:center;border:1px solid red;padding-top:5px;margin-top:5px;">
			
		</div>
		<div>
			<button type="button" id="signout" class="s">退出</button>
		</div>
	</div>
</body>
</html>