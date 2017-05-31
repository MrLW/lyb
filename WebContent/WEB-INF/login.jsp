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

<title>首页</title>
</head>
<body>
	<div class="container" style="width: 60%; margin-top: 5%;">
		<form action="/lyb/StudentLoginServlet">
			<div class="form-group">
				<label for="exampleInputEmail1">用户名</label> <input type="text"
					class="form-control" id="username" name="username"
					placeholder="用户名">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">密码</label> <input type="password"
					class="form-control" id="password" name="password" placeholder="密码">
			</div>
			<div class="checkbox">
				<label> <input type="checkbox"> 记住我
				</label>
				<label style="color: red;">
					${error }
				</label>
				<button type="submit" class="btn btn-default">登录</button>
				<a class="btn btn-default" href="regist.jsp" role="button">Link</a>
			</div>
			
		</form>
	</div>
</body>
</html>