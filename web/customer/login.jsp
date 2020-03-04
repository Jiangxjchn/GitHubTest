<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jiangxj
  Date: 2019/12/18
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="assets/lib/bootstrap/dist/css/bootstrap.min.css">3
    <link rel="stylesheet" type="text/css" href="../styles.css">
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <h1>Welcome</h1>
            <s:form class="form" action="login" method="post" namespace="/">
                <s:textfield class="in" name="customer.account" label="account"/>
                <s:password class="in" name="customer.password" label="password"/>
                <button type="submit" id="login-button">Login</button><br><br>
            </s:form>
        </div>
    </div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
    <h1>用户登录</h1>
</div>
</body>
</html>