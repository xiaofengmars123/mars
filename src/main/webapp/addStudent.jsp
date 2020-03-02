<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>t添加學員</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student" method="post">
    学号:<input type="text" name="id"><br>
    姓名:<input type="text" name="name"><br>
    年龄:<input type="text" name="pwd"><br>
    邮箱:<input type="text" name="email"><br>
    <button type="submit">添加学员</button>
</form>
</body>
</html>
