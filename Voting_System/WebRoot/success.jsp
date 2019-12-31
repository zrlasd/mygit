<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录成功！</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css" rel="stylesheet">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="success.css">
  </head>
  <body>
  	 <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">${user}</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="#">首页</a></li>
                  <li><a href="#">关于</a></li>
                  <li><a href="/Voting_System/login.jsp">退出</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
          	<!--用EL语句调用出存到session里的usename  -->
            <h1 class="cover-heading">欢迎${user}来投票</h1>
            <p class="lead"></p>
            <p class="lead">
              <a href="vote.jsp" class="btn btn-lg btn-default">点击投票</a>
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p> </p>
            </div>
          </div>

        </div>

      </div>

    </div>
   	
  </body>
</html>
