<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
<h1>index</h1>
<shiro:hasPermission name="/logout">
    <a href="/logout">logout</a>
</shiro:hasPermission><shiro:hasPermission name="/addPage">
    <a href="/addPage">addPage</a>
</shiro:hasPermission><shiro:hasPermission name="/add">
    <a href="/add">add</a>
</shiro:hasPermission><shiro:hasPermission name="/manager">
    <a href="/manager">manager</a>
</shiro:hasPermission><shiro:hasPermission name="/dataGrid">
    <a href="/dataGrid">dataGrid</a>
</shiro:hasPermission>


登陆名称
<shiro:principal></shiro:principal>

<shiro:hasRole name="admin">
    <br><br>
    <a href="admin.jsp">Admin Page</a>
</shiro:hasRole>

<shiro:hasRole name="user">
    <br><br>
    <a href="user.jsp">User Page</a>
</shiro:hasRole>
</body>
</html>
