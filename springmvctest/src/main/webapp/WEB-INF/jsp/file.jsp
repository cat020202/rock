<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>表单上传文件</h1>
<form name="Form2" action="springUpload.do" method="post"  enctype="multipart/form-data">
<p>选择文件:<input type="file" name="files"></p>
<p>选择文件:<input type="file" name="files"></p>
<span style="color:red">${info}</span>
<input type="submit" value="upload"/>
</form>

</body>
</html>