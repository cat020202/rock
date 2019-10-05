<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="copyright" content="All Rights Reserved, Copyright (C) 2018, Wuyeguo, Ltd." />
<title>首页</title>
<script type="text/javascript" src="myjs/jquery.min.js"></script>
</head>
<body>
		<div style="position:absolute;top:300px;left:30%">

			<form action="login.do" method="post">
	
					用户名：<input type="text" name="userName"> 
					密码：<input type="password" name="userPwd"> 
					验证码：<input type="text" name="valCode"> 
					<br>
					<span style="color:red">${requestScope.info}</span>
					<img id="vimg" src="valCode.do" width="160" height="40" onclick="resh()">	
					<button type="submit">登录</button>
			</form>
			</div>
</body>
<script>
		function resh(){
			//获取现在时间的原始值
	    	var timestamp = (new Date()).valueOf();
			console.log(timestamp)
			//取出原src
	    	var url = $("#vimg").attr("src");
			//在原src后面拼接时间戳
	    	url = url + "?timestamp=" + timestamp;
			//将改变的后的url赋值给src
	    	$("#vimg").attr("src", url);
		}
</script>
</html>