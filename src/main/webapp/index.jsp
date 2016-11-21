<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVC Sample Applirication Menu</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resource/css/index.css"/>
<!--  スクリプトへのリンク例 
<script src="/js/bootstrap.min.js"></script>
-->

</head>
<body>

<div class="nav">

<ul class="nl">
  <li><a href="<%= request.getContextPath() %>/HelloWorld">HelloWorld!</a></li>
  <li><a href="<%= request.getContextPath() %>/user/edit/input.html?user.id=001">画面入力・バリデーションサンプル</a></li>
</ul>

</div>


</body>
</html>