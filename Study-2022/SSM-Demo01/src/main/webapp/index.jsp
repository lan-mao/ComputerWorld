<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        h2{
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background-color: deepskyblue;
            border-radius: 5px;
        }
        a{
            text-decoration: none;
            color: black;
            font-size:18px;
        }
    </style>
</head>
<body>

<h2><a href="${pageContext.request.contextPath}/book/all">Book</a></h2>
</body>
</html>