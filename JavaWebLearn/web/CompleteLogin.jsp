<%--
  Created by IntelliJ IDEA.
  User: Clearlight
  Date: 2019/11/21
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/identifyCodeServlet?time=" + new Date().getTime();
            }
        }
    </script>

    <style>
        div {
            color: red;
        }
    </style>
</head>
<body>
<form action="/LoginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>

            <td colspan="2"><img id="img" src="/identifyCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="登录"></td>
        </tr>
    </table>
</form>

<div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
<div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%></div>
</body>
</html>
