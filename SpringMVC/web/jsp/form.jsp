<%--
  Created by IntelliJ IDEA.
  User: 12641
  Date: 2020/9/20 020
  Time: 10:59:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/source/js/jquery-2.0.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                const data = {username: "test", password: "t"};
                $.ajax({
                    url: "${pageContext.request.contextPath}/request/get",
                    type: "post",
                    contentType: "application/json",
                    data:JSON.stringify(data)
                })
            })
        })
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/request/get" method="get">
    <label>
        <input type="text" name="username"/>
    </label>
    <label>
        <input type="password" name="password"/>
    </label>
    <label>
        <input type="text" name="partner.username"/>
    </label>
    <br>
    <label>
        <input type="checkbox" name="checkbox" value="a1">
    </label>
    <label>
        <input type="checkbox" name="checkbox" value="a2">
    </label>
    <label>
        <input type="checkbox" name="checkbox" value="a3">
    </label>
    <label>
        <input type="checkbox" name="checkbox" value="a4">
    </label>
    <input type="submit">
</form>
<br>
<button id="submit" >点点哦</button>

</body>
</html>
