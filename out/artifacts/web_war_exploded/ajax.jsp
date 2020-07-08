<%--
  Created by IntelliJ IDEA.
  User: hby84
  Date: 2020/7/7
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/gh/stevenjoezhang/live2d-widget@latest/autoload.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome/css/font-awesome.min.css">

    <title>Title</title>
    <script src = "js/jquery-2.1.0.js"></script>
    <script>
        $(function () {
            $("#buttonid").click(function () {
                //功能    文本框     输入      点击按钮        返回条件
                $.ajax({
                    url:"servlet/AjaxServlet",
                    type:"post",
                    dataType:"html",
                    data:{'username':$('#inputid').val()},
                    success:function (data) {
                        var v = eval(data);//字符串转数组
                        //字符串拼接
                        //获取DOM节点   append()节点后增加内容
                        $("#divid").append("<table border='1' width = '30%'>");
                        $("table").append("<tr>" +
                            "<td><input type = 'checkbox' id = 'checkboxall'/>全选</td>   " +
                            "<td>序号</td>" +
                            "<td>用户名</td>" +
                            "<td>密码</td>" +
                            "</tr>");
                        //循环数据
                        $.each(v,function(index) {
                            $("table").append("<tr>" +
                                "<td><input type = 'checkbox'/></td>   " +
                                "<td>"+v[index].id+"</td>" +
                                "<td>"+v[index].username+"</td>" +
                                "<td>"+v[index].password+"</td>" +
                                "</tr>");
                        })
                        $("#divid").append("</table>")
                    }
                })

            })
        })
    </script>
</head>
<body>
            静态内容
            <input type="text" id="inputid"/>
            <input type="button" value="ajax" id="buttonid"/>
            <div id="divid"></div>
            <div id="live2d-widget">
                <%--    <canvas id="live2dcanvas" width="400" height="800" style="position: fixed;opacity: 0.7;right: 0px;bottom: -20px;z-index: 99999;pointer-events: none;border: 1px dashed rgb(204, 204, 204);">--%>
                <%--    </canvas>--%>
            </div>
</body>
</html>
