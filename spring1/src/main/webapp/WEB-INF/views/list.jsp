<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee list</title>
</head>
<style>
td{border:1px solid red;}
</style>
<body>
<table style='border-collapse:collapse'>
<c:forEach var="empDTO" items="${list}">
<tr><td>${empDTO.employee_id}</td><td>${empDTO.emp_name}</td>
	<td>${empDTO.salary}</td><td>${empDTO.manager_id}</td></tr>
</c:forEach>
</table>
</body>
</html>