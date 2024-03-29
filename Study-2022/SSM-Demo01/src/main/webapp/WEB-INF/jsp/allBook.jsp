<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: lan-mao.top
  Date: 2022/1/24 21:56:25
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>书籍展示</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
</head>
<body>
<div class="container">

    <%--设为行，清除浮动--%>
    <div class="row clearfix">
        <%--12份栅格，设为列--%>
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表——显示所有</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 column">
            <a href="${pageContext.request.contextPath}/book/toAddBook" class="btn btn-default">增加书籍</a>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td>${book.bookId}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCount}</td>
                            <td>${book.bookDetail}</td>
                            <td>
                                <a href="#">修改</a>
                                &nbsp; | &nbsp;
                                <a href="#">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>