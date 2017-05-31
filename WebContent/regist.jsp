<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">

<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h1 align="center">留言本--注册</h1>
	<div class="container" style="width: 60%; margin-top: 5%;">
		<form action="/lyb/StudentRegistServlet">
			<div class="form-group">
				<label for="exampleInputEmail1">用户名</label> <input type="text"
					class="form-control" id="username" name="username"
					placeholder="用户名">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">密码</label> <input type="password"
					class="form-control" id="password" name="password" placeholder="密码">
			</div>
			<label class="radio-inline"> <input type="radio"
				name="type" id="inlineRadio1" value="0">
				普通用户
			</label> 
			<label class="radio-inline"> <input type="radio"
				name="type" id="inlineRadio2" value="1">
				管理员
			</label> 
			<div class="checkbox">
				<button type="submit" class="btn btn-default">注册</button>
			</div>

		</form>
	</div>
</body>
</html>