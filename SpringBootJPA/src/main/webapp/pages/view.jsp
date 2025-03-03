<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>MENU</title>
</head>
<body>

<form >
<c:if test="${not empty message}">
        <p class="error-message">${message}</p>
    </c:if>
<c:if test="${not empty list}">
<table border="1">
<caption>Employee List</caption>
<tr>
<th>Employee ID</th>
<th>Employee name</th>
<th>Employee Designation</th>
</tr>
<c:forEach var="row" items="${list }">
<tr>
<td><c:out value="${row.eno }"/></td>
<td><c:out value="${row.ename }"/></td>
<td><c:out value="${row.desig }"/></td>
</tr>
</c:forEach>



</table>
</c:if>
</form>
<a href="welcome">HOME</a>

</body>
</html>