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
${pageContext.request.contextPath}
<%--噔噔蹬--%>
<%!
    public static int a = 0;
%>
<% int x = 0;%>
<p>
    <% out.print("x="); %>
</p>
<% out.print(x); %>

<% for (int i = 0; i < 6; i++){ %>
    <h<%=i%>><%=i%></h<%=i%>>
<%}%>

<%!
    static {
        System.out.println("加载JSP页面");
    }

    public void x() {
        System.out.println("进入JSP页面");
    }
%>
</body>
</html>