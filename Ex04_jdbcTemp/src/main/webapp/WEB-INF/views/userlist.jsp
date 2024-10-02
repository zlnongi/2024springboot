<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-10-02
  Time: 오후 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="dto" items="${users}">
${dto.id} / ${dto.name}
</c:forEach>
</body>
</html>
