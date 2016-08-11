<%--
  Created by IntelliJ IDEA.
  User: shuyun
  Date: 2016/8/10
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<table>
    <tr>
        <th colspan="2">文章列表</th>
    </tr>

    <tr>
        <td>1</td>
        <td>
            <a href="/article/details/1" target="_blank">文章一</a>
        </td>
    </tr>

    <tr>
        <td>2</td>
        <td>
            <a href="${pageContext.request.contextPath}/article/details/2" target="_blank">文章二</a>
        </td>
    </tr>

</table>
</body>
</html>
