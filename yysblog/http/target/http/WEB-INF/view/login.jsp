<%--
  Created by IntelliJ IDEA.
  User: 杨永生
  Date: 2017/9/4
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>login</h1>
<form action="/register" method="post">
    <input type="text" name="userName" value="admin2">
    <input type="text" name="password" value="admin">
    <button type="submit">register</button>
</form>
<form action="/login" method="get">
    <input type="text" name="userName" value="admin">
    <input type="text" name="password" value="admin">
    <button type="submit">login</button>
</form>
<form action="/login" method="post">
    <input type="text" name="userName" value="admin">
    <input type="text" name="password" value="admin">
    <button type="submit">login</button>
</form>
</body>
</html>
