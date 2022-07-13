<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페</title>
</head>
<style>
td{border:1px solid red;}
</style>
<body>
<table style='border-collapse:collapse'>
<c:forEach var="menu" items="${menulist}">
<tr><td><a href="delete?${menu.seqno}">${menu.seqno}</a></td><td>${menu.name}</td>
	<td>${menu.price}</td></tr>
</c:forEach>
</table>
</body>
</html>