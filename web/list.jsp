<%--
  Created by IntelliJ IDEA.
  User: Eiche
  Date: 2020/11/20
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="85%" align="center" cellpadding="5" cellspacing="5">
    <tr>
        <td colspan="3" bgcolor="#7fffd4">
            <pre> ${treelist} </pre>
        </td>
    </tr>
    <tr>
        <td align="middle" colspan="3" bgcolor="#7fffd4">
            <a  href="<c:url value='/index.jsp'/>">返回主页</a>
        </td>
    </tr>
</table>
</body>
</html>
