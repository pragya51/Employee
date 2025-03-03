<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="empsave" modelAttribute="empBean">
Emp Name:<form:input path="ename"/>
Emp Desig :<form:input path="desig"/>
<input type="submit" value="submit"/>
</form:form>

</body>
</html>