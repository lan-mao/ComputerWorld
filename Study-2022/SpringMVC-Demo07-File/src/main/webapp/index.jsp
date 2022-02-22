<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/upload2" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="提交"/>
</form>
</body>
</html>