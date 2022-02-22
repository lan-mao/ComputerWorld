<%--
  User: lan-mao.top
  Date: 2022/1/13 013 9:32:59
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>

    <script>
        function a1() {
            // console.log($("#username").val())
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data:{"username":$("#username").val()},
                success:function (data) {
                    console.log(data);
                    $("#userInfo").html(data)
                },
            })
        }
        function a2() {
            console.log($("#password").val())
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                // data:{"password":$("#password").val()},
                success:function (data) {
                    console.log(data);
                    $("#pwdInfo").html(data)
                },
            })
        }
    </script>

</head>
<body>

<p>
    <label for="username">用户名：</label><input type="text" id="username" onblur="a1()"/>
    <span id="userInfo"></span>
</p>

<p>
    <label for="password">密码：</label><input type="password" id="password" onblur="a2()"/>
    <span id="pwdInfo"></span>
</p>

</body>
</html>