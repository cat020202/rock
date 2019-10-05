<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright" content="All Rights Reserved, Copyright (C) 2018, Wuyeguo, Ltd." />
<title>首页</title>
		<script src="js/jquery.min.js" type="text/javascript"></script>

 </head>
<body>
<h1>表单登录</h1>
	<form action="login.do" method="post">
		用户名:<input type="text" name="userName">
		<br>
		密码:<input type="password" name="userPwd">
		<br>
		${param.info}
		<input type="submit" value="登录">
	</form>
	<h1>ajax实现登录</h1>
		用户名:<input type="text" id="userName">
		<br>
		密码:<input type="password" id="userPwd">
		<br>
		<input type="button" value="登录" onclick="login()">
</body>
</html>
<script type="text/javascript">
	function login(){
		
		var name = $("#userName").val();
		var pwd = $("#userPwd").val();
		$.ajax({
			url:"loginAjax.do",
			type:"post",
			data:{"userName":name,"userPwd":pwd},
			success:function(data){
				console.log(data)
				if(data.info){
					//window.location.href="index.do"
				}
			}
		})
	}
</script>
