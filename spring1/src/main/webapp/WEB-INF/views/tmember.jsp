<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T멤버</title>
</head>
<style>
td{border:1px solid red;}
</style>
<body>
<form id=frmAddnew method=POST action="addMember">
<h3>USER ID </h1><input type=text name=tid><br>
<h3>Password </h1><input type=text name=tpwd1 id=tpwd1><br>
<h3>Password 확인 </h1><input type=text name=tpwd2 id=tpwd2><br>
<h3>이름 </h1><input type=text name=tname><br>
<h3>모바일 </h1><input type=text name=tmobile><br>
<input type=submit value='추가' id="btn1">&nbsp;<input type=reset value='비우기'>
</form>
<table style='border-collapse:collapse'>
<tr><td>User ID</td><td>비밀번호</td>
<td>이름</td><td>모바일</td><td>가입일</td></tr>
<c:forEach var="member" items="${memberlist}">
<tr><td>${member.id}</td><td>${member.pwd}</td>
	<td>${member.name}</td><td>${member.mobile}</td>
	<td>$/{member.joindate}</td></tr>
</c:forEach>
</table>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.js">
</script>
<script>
$(document)
.on('click','#btn1',function(){
	if($('#tpwd1').val()!=$('#tpwd2').val()){
		alert("비밀번호가 일치하지 않습니다");
		return false;
	}
})
</script>
</html>