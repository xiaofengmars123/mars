<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script>
        $(function () {
            loadData();//初始化加载数据
            

        })

        function loadData() {
            //ajax是异步操作的，我们不要去等它返回数据，接着可以直接往下操作
            $.get("${pageContext.request.contextPath}/students",function (data) {
                if(data.code==5000){
                    window.location.href="${pageContext.request.contextPath}/error.jsp";
                }
                /*遍历函数，从数组取一个就执行一次函数，函数中的参数，第一个是，取出来的元素在数组中的下标，第二个参数是具体遍历出来的数据*/
                $.each(data,function (i,obj) {
                   $tr=$("<tr align='center'></tr>");//创建一个元素
                    $td1=$("<td>"+obj.id+"</td>");
                    $td2=$("<td>"+obj.name+"</td>");
                    $td3=$("<td>"+obj.pwd+"</td>");
                    $td4=$("<td>"+obj.email+"</td>");
                    $td5=$("<td><input type=\"button\" class=\"btn_del\" value=\"删除\"><input type=\"button\" class=\"btn_update\" value=\"更新\"></td>");
                    $tr.append($td1).append($td2).append($td3).append($td4).append($td5);
                    $("#tbody").append($tr);
                })

                $(".btn_del").click(function () {
                    var id=$(this).parent().parent().children("td").first().html();
                    $("#dataForm").attr("action","${pageContext.request.contextPath}/student/"+id);
                    $("#transfer").attr("value","delete");
                    $("#dataForm").submit();//提交表单
                })

                $(".btn_update").click(function () {
                    var id=$(this).parent().parent().children("td").first().html();
                    $("#dataForm").attr("action","${pageContext.request.contextPath}/student/"+id);
                    $("#dataForm").attr("method","get")
                    $("#dataForm").submit();//提交表单
                })
            });
        }
    </script>
</head>
<body>
<table width="50%" border="1">
    <thead>
    <tr>
        <th>学号</th>
        <th>名字</th>
        <th>年龄</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="tbody">
   <%-- <c:forEach items="${requestScope.stus}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.email}</td>
            <td>
                <input type="button" class="btn_del" value="删除">
                <input type="button" class="btn_update" value="更新">
            </td>

        </tr>
    </c:forEach>--%>
    </tbody>
</table>
<br>
<form action="" method="post" id="dataForm">
     <input type="hidden" name="_method" id="transfer" value="">
</form>
<a href="${pageContext.request.contextPath}/addStudent.jsp">添加学员</a>

<%--回去，把首页的功能改成ajax来完成，服务器端返回时JSON对象，客户端从json取数据进行遍历输出--%>
</body>
</html>
