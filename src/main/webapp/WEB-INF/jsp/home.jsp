<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
Hello!!!



<c:forEach var="post" items="${articles}">
    <c:out value="${post.getId()}"/>

</c:forEach>

</body>
</html>
