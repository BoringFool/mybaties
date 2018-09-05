<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-min.js"></script>
<script type="text/javascript">
	function test() {
		$.ajax({
			type : "get",
			url : "http://localhost:8080/mybaites/user/test",
			dataType : "json",
			success : function(data) {
				
				alert(data);
				alert(data.username+data.age);
				
			},
			error : function() {
				alert("wrong!");
			}
		});
	}
	$(document).ready(function() {
		$("button#t").click(function() {
			test();
		});
	});
</script>
</head>
<body>
	<button id="t" type="button">测试</button>
</body>
</html>