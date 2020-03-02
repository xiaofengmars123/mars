<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>更新學員</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student" method="post">
    <input type="hidden" name="_method" value="PUT">
    学号:<input type="text" name="id" readonly="readonly" value="${stu.id}"><br>
    姓名:<input type="text" name="name" value="${stu.name}"><br>
    年龄:<input type="text" name="pwd"  value="${stu.pwd}"><br>
    邮箱:<input type="text" name="email" value="${stu.email}"><br>
    <button type="submit">更新学员</button>
</form>
</body>
</html>
