<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset=UTF-8>
    <title>This page is running in standards mode!</title>
  </head>
<link rel="stylesheet" href="/static/css/messageForm.css">
<body>

<div class="container">
	<div class="nickname">받는 사람: ${user.nickname}</div>
	<form action="/user/auth/send-Proc/${user.id}" method="post">
		<textarea id="mytextarea" name="message"  rows="15" cols="60">
		</textarea>
		<input type="submit" value="보내기">
	</form>
	
</div>
</body>
</html>