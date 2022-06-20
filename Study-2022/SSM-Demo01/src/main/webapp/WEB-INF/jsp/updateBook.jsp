<%--
  User: lan-mao.top
  Date: 2022/3/18 11:56
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加书籍</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表——添加书籍</small>
                </h1>
            </div>
        </div>

        <%--placeholder 文本框提示信息；required 必须填写此文本框；--%>
        <%--label标签，文本标签，for代表对应的input框，点击跳转至对应框中--%>
        <form action="${pageContext.request.contextPath}/book/addBook" method="post">
            <div class="form-group">
                <label for="name">书籍名称</label>
                <input type="text" class="form-control" id="name" placeholder="书籍名称" name="bookName" required/>
            </div>
            <div class="form-group">
                <label for="count">书籍数量</label>
                <input type="number" class="form-control" id="count" placeholder="书籍数量" name="bookCount" required/>
            </div>
            <div class="form-group">
                <label for="detail">书籍详情</label>
                <input type="text" class="form-control" id="detail" placeholder="书籍详情" name="bookDetail" required/>
            </div>

            <button type="submit" class="btn btn-default">提交</button>
        </form>

    </div>
</div>
</body>
</html>