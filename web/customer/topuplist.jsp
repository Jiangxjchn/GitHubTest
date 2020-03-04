<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/1/9
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>充值流水</center>
<table border=1>
    <tr>
        <th>单号</th>
        <th>账户</th>
        <th>充值金额</th>
        <th>时间</th>
    </tr>
    <s:iterator value="list" var="object">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="account"/></td>
            <td><s:property value="number"/></td>
            <td><s:property value="time"/></td>
        </tr>
    </s:iterator>

</table>
</body>
</html>
