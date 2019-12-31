<%@ page language="java" import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>登录</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css" rel="stylesheet">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="login.css">
  </head>
  
  <body>
  	<div class="container">
        <div class="blog-post form-signin">
        	${message}<br>
        	<form action ="${pageContext.request.contextPath}/login" method="post">
	            <h2 class="form-signin-heading">请登录</h2>
	            <label for="username" class="sr-only">user</label>
	            <input type="input" id="inputEmail" class="form-control" name="username" placeholder="用户名" required autofocus>
	            <label for="password" class="sr-only">密码</label>
	            <input type="password" id="inputPassword" class="form-control" name="password" placeholder="密码" required>
	            <div class="checkbox">
	              <label>
	                <input type="checkbox" value="remember-me"> 记住密码？
	              </label>
	            </div>
	            <button class="btn btn-lg btn-primary btn-block" type="submit">登 录</button>
	         </form>
        </div>
    </div>
    <footer class="blog-footer">
      <p> </p>
    </footer>
  </body>
</html>
