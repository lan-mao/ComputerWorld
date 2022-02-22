<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<script>
    const user = {
        name: "姓名",
        age: 12,
        sex: "male"
    };

    console.log(user)

    const js = JSON.stringify(user);

    console.log(js)

    const object = JSON.parse(js);

    console.log(object)
</script>
</body>
</html>