<%--
  Created by IntelliJ IDEA.
  User: 12641
  Date: 2020/9/20 020
  Time: 9:51:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${param.username}<br>
${param.password}<br>
${sessionScope.object.username}<br>
${pageContext.request.contextPath}<br>
<a href="tel:13869799842">tel</a><br>
<a href="wtai://wp//mc;13764567708">拨打10086 </a> <br>
<a href="wtai://wp/ap;13764567708;">将10086存储至电话簿 </a><br>
<a href="sms:13764567708">移动WEB页面JS一键发送短信咨询功能</a><br>
<a href="dc:13764567708">移动WEB页面JS一键拨打号码咨询功能</a>
</body>
</html>
