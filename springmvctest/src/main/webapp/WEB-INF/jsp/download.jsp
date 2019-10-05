<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form aciton="download" method="post">
<table>
	<thead>
	<th>文件名称</th>
	<th>操作</th>
	</thead>
	<tbody>
	<tr>
		<td>1.xls</td>
		<td>
		<input type="hidden" name="filePath" value="1.xls">
		<input type="submit" value="点击下载">
		</td>
	</tr>
	</tbody>
</table>
</form>

</body>
</html>