<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="UTF-8">
<title>Deletion</title>
</head>
<body>
<form:form action="deleteid" modelAttribute="empBean">
<label for="employeeId">Employee ID: </label>
        Emp No:<form:input path="eno"/>
        <button type="submit">Delete Employee</button>
        </form:form>

</body>
</html>