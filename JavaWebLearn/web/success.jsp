<%--
  Created by IntelliJ IDEA.
  User: Clearlight
  Date: 2019/11/21
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h1><%= request.getSession().getAttribute("user")%>
</h1>
</body>
</html>
