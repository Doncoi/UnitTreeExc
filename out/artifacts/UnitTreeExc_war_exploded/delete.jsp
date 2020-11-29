<%--
  Created by IntelliJ IDEA.
  User: Eiche
  Date: 2020/11/21
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/DeleteServlet" method="post">
    <input type="hidden" name="method" value="add">
    <table border="0" align="center"  style="width:600px; margin:44px auto" class="table">
        <tr>
            <td width="100px">待删除结点ID</td>
            <td width="40%">
                <input type="text" name="id"/>
            </td>
            <td align="left">
                <label id="idError" class="error">&nbsp;</label>
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
