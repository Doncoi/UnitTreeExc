<%--
  Created by IntelliJ IDEA.
  User: Eiche
  Date: 2020/11/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加结点</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/EditNameServlet" method="post">
    <input type="hidden" name="method" value="add">
    <table border="0" align="center"  style="width:600px; margin:44px auto" class="table">
        <tr>
            <td width="100px">待修改结点ID：</td>
            <td width="40%">
                <input type="text" name="id"/>
            </td>
            <td align="left">
                <label id="idError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>将节点名称修改为：</td>
            <td>
                <input type="text" name="name" id="name"/>
            </td>
            <td>
                <label id="nameError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" class="btn btn-primary"/>
                <input type="reset" name="reset" class="btn btn-default"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
