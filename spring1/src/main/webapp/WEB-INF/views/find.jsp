<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
td{border:1px solid red;}
</style>
<body>
<h1>사원정보</h1>
사번: ${mi.m.employee_id}<br>
이름: ${mi.m.emp_name}<br>
월급: ${mi.m.salary}<br>
매니저이름: ${mi.m.manager_name}<br>
입사일자: ${mi.m.hire_date}<br>
이메일: ${mi.m.email}<br>
팀원숫자: ${mi.n}<br>
<table style='border-collapse:collapse'>
<c:forEach var="empDTO" items="${mi.mDTO}">
<tr><td>${empDTO.employee_id}</td><td>${empDTO.emp_name}</td>
	<td>${empDTO.salary}</td><td>${empDTO.manager_id}</td></tr>
</c:forEach>
</table>
</body>
</html>