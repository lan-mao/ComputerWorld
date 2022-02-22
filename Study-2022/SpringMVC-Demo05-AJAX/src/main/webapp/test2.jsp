<%--
  User: lan-mao.top
  Date: 2022/1/12 012 17:41:22
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.post("${pageContext.request.contextPath}/a2", function (data) {
                    // console.log(data);

                    let html = "";

                    for (let i = 0; i < data.length; i++) {
                        html += "<tr> " +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "<td>" + data[i].sex + "</td>" +
                            "</tr>"
                    }

                    $("#content").html(html);
                })
            })
        });
    </script>
</head>
<body>

<input type="button" value="加载数据" id="btn"/>

<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content"></tbody>
</table>
</body>
</html>