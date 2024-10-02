<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-10-02
  Time: 오전 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
${lists}

당신의 이름은 ${name}입니다.

<c:forEach var="myList" items="${lists}">
    <div>${myList}</div>
</c:forEach>
</body>
</html>
