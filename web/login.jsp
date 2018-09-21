<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 9/21/2018
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    <div>Username <input type="text" name="username" value="Daniel"></div>
    <div>Password <input type="password" name="pass" value="123"></div>
    <div>
        Remember me:
        <input type="checkbox" name="remember">
    </div>
    <div><input type="submit"></div>
</form>
<div style="color: red;">${message}</div>
</body>
</html>
