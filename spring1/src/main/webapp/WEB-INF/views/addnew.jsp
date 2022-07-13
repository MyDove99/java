<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu 추가</title>
</head>
<style>
td{border:1px solid red;}
</style>
<body>
<form id=frmAddnew method=POST action="addMenu">
<input type=text name=mname><br>
<input type=number name=price><br>
<input type=submit value='추가'>&nbsp;<input type=reset value='비우기'>
</form>
<table style='border-collapse:collapse'>
<c:forEach var="menu" items="${menulist}">
<tr><td><a href="delete?seqno=${menu.seqno}">${menu.seqno}</a></td><td>${menu.name}</td>
	<td>${menu.price}</td><td><a href='view?seqno=${menu.seqno}'>수정</a></td></tr>
</c:forEach>
</table>
</body>
</html>