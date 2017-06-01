<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">

<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h1 align="center" style="margin-top: 3%;">2014级计算机1班留言板</h1>

	<div align="left" style="margin-left: 5%; margin-top: 3%">
		<a class="btn btn-default" href="chart.jsp" role="button"
			style="margin-left: 45%;">查看留言报表报表</a>
	</div>

	<div align="right" style="margin-right: 5%; margin-top: 3%">

		<c:if test="${student.username == null }">
您当前还没有登录,请先<a href="/lyb/login.jsp">登录</a>.
</c:if>
		<c:if test="${student.username != null }">
欢迎光临,${student.username }

<a href="/lyb/StudentLogoutServlet">注销</a>
		</c:if>
	</div>

	<hr>

	<form action="/lyb/MessageServlet" style="width: 80%; margin-left: 17%">
		<h3 align="center">请选择要留言的标题：</h3>
		<c:forEach items="${titleList }" var="title" varStatus="status">
			<div class="radio" align="center">
				<label> <input ${status.index == 0 ? "checked" : ""} type="radio" name="title" id="optionsRadios1"
					value="${title.name }" >${title.name }  
				</label>
			</div>
		</c:forEach>

		<textarea class="form-control" rows="4" name="content"></textarea>
		<input class="btn btn-default" type="submit" value="提交"
			style="margin-top: 1%;"> <input type="hidden" value="2"
			name="operator">
		<div style="color: red;">${noLogin }</div>
	</form>
	<br>
	<div class="bs-example" data-example-id="list-group-custom-content"
		style="width: 80%; margin-left: 17%">
		<c:if test="${student.username != null }">
			<c:forEach items="${page.messages }" var="msg">
				<div class="list-group">
					<a href="#" class="list-group-item">
						<h4 class="list-group-item-heading">${msg.title }</h4> <br>
						<p class="list-group-item-text">${msg.content }</p>
						<p class="list-group-item-text" align="right">
							${msg.createTime}
							<c:if test="${student.type != 1 }">
								<c:if test="${student.id == msg.sid }">
									<a href="/lyb/MessageServlet?operator=1&deleteId=${msg.id }">删除</a>
								</c:if>
							</c:if>
							<c:if test="${student.username == 'root' }">
								<a href="/lyb/MessageServlet?operator=1&deleteId=${msg.id }">删除</a>
							</c:if>
						</p>
					</a>
				</div>
			</c:forEach>
		</c:if>

	</div>
	<c:if test="${student!=null }">

		<nav aria-label="Page navigation" style="width: 80%; margin-left: 40%">
		<ul class="pagination">

			<li><c:if test="${page.curPage <=1 }">
					<a href="/lyb/IndexServlet?curPage=${ page.totalPages }"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a>
				</c:if> <c:if test="${page.curPage> 1 }">
					<a href="/lyb/IndexServlet?curPage=${ page.curPage-1 }"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a>
				</c:if></li>

			<c:forEach begin="1" end="${page.totalPages }" var="i">
				<li class="${page.curPage == i ? "active" : "" }"><a
					href="/lyb/IndexServlet?curPage=${ i }">${i }</a></li>
			</c:forEach>

			<li><c:if test="${(page.curPage+1) > page.totalPages }">
					<a href="/lyb/IndexServlet?curPage=1" aria-label="Next"> <span
						aria-hidden="true">&raquo;</span>
					</a>
				</c:if> <c:if test="${page.curPage+1 <= page.totalPages }">
					<a href="/lyb/IndexServlet?curPage=${page.curPage+1 }"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a>
				</c:if></li>
		</ul>
		</nav>
	</c:if>


</body>
</html>