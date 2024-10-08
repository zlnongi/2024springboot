<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-10-08
  Time: 오후 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
총 글 개수 : ${totalElements} <br>
총 페이지 : ${totalPages} <br>
size : ${size} <br>
page Number : ${pageNumber} <br>
number of elements : ${numberOfElements} <br>

<c:forEach var="member" items="${members}">
    ${member.id} / ${member.name} / ${member.email}
</c:forEach>
</body>
</html>
