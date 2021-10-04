<%--
  Created by IntelliJ IDEA.
  User: 12641
  Date: 2020/9/22 022
  Time: 14:51:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload/single" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFile"/>
    <input type="submit" value="上传">
</form>

<br>
以下是多文件上传
<br>

<form action="${pageContext.request.contextPath}/upload/multiple" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFiles"/>
    <input type="file" name="uploadFiles"/>
    <input type="file" name="uploadFiles"/>
    <input type="file" name="uploadFiles"/>
    <input type="file" name="uploadFiles"/>
    <input type="submit" value="上传多个文件">
</form>
</body>
</html>
