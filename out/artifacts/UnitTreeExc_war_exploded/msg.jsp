<%--
  Created by IntelliJ IDEA.
  User: Eiche
  Date: 2020/11/21
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>message</title>
</head>
<body>
<table width="85%" align="center" cellpadding="5" cellspacing="5">
    <tr>
        <td align="middle" colspan="2">
            <h1 style="color:green;" align="center">${msg}</h1>
        </td>
    </tr>
    <tr>
        <td align="middle">
            <a align="center" href="<c:url value='/ListServlet'/>">结点信息</a>
        </td>
        <td align="middle">
            <a align="center" href="<c:url value='/index.jsp'/>">返回主页</a>
        </td>
    </tr>
</table>

</body>
</html>
