<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<title>投票</title>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css"
	rel="stylesheet">
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<!-- 主体 -->
	<div class="container">
		<div class="blog-post form-signin">
			${message}<br>
			<form action="${pageContext.request.contextPath}/vote" method="get">
				<h2 class="form-signin-heading">欢迎来投票</h2>
				${count} <label for="username" class="sr-only">user</label>
				<div class="radio">
					<label> <input type="radio" name="username"
						id="optionsRadios1" value="wangwu" checked> 王五
					</label>
				</div>
				<div class="radio">
					<label> <input type="radio" name="username"
						id="optionsRadios2" value="zhaoliu"> 赵六
					</label>
				</div>
				<p>
					<input type="submit" value="投ta一票" class="btn btn-success">

				</p>
				<label for="password" class="sr-only">密码</label>

			</form>
		</div>
	</div>
	<!-- 页脚 -->
	<footer class="blog-footer">
	<p></p>
	</footer>
</body>
</html>
