<%--
  Created by IntelliJ IDEA.
  User: 12641
  Date: 2020/8/30 030
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome SpringMVC</title>
</head>
<body>
    <%
    String contextPath = request.getContextPath(); // 当前项目名： /SpringMVC_Web_exploded
    String scheme = request.getScheme(); //当前协议
    String server = request.getServerName(); //当前的网站域名，如 localhost
    String port = String.valueOf(request.getServerPort()); //当前的网站端口
    //当前路径的绝对路径组合方式：
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath;
    %>
<%--    <base href="<%=basePath%>"/>--%>
<%--    <base href=${pageContext.request.contextPath} />--%>
    <img style="width: 155px" src="${pageContext.request.contextPath}/source/img/Snipaste_2020-09-04_16-45-02.png" />
    <%=contextPath%> <br>
<%=basePath%><br>
<%=request.getRemotePort()%><br>
<%=request.getLocalPort()%>
</body>
</html>
