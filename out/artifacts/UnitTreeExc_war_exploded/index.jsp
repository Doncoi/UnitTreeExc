<%--
  Created by IntelliJ IDEA.
  User: Doncoi
  Date: 2020/11/3
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UnitTree</title>
</head>

<body onload="load()">
    <h1>UnitTree</h1>
    <hr></hr>
        <a href="<c:url value='/ListServlet'/>">结点信息</a>
    <hr></hr>
        <a href="<c:url value='/add.jsp'/>">添加结点</a>
    <hr></hr>
        <a href="<c:url value='/delete.jsp'/>">删除结点</a>
    <hr></hr>
        <a href="<c:url value='/editname.jsp'/>">修改结点名称</a>
    <hr></hr>
        <a href="<c:url value='/editparent.jsp'/>">修改结点关系</a>
    <hr></hr>
</body>
</html>
