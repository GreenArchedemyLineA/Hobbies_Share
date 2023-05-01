<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div>받는 사람: ${user.nickname}</div>
	<form action="/user/auth/send-Proc/${user.id}" method="post">
		<input type="text" name="message">
		<input type="submit" value="보내기">
	</form>
	
	
</div>
</body>
</html>