<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script>
        function a() {
            $.post({
                url: '${pageContext.request.contextPath}/a1',
                data: {"name":$("#username").val()},
                success: function (data,status) {
                    console.log("data: " + data);
                    console.log("status: " + status);
                },
                error: function () {

                },
            })
        }

    </script>
</head>
<body>

<label for="username">用户名：</label><input type="text" id="username" onblur="a()">

</body>
</html>