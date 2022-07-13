<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Menu</title>
</head>
<body>
<form id=frmUpdate action="update" method='post'>
<input type=hidden name=seqno value="${mdto.seqno}">
메뉴명: <input type=text name=name value="${mdto.name}"><br>
가격: <input type=number name=price value="${mdto.price}"><br>
<input type=submit value='수정'>&nbsp;
<input type=reset value='비우기'>
</form>
</body>
</html>