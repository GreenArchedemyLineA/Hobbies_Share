<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�Խñ� ����</h1>
	<form action="/board/update-proc/${board.id}" method="post">

		<input type="text" id="title" name="title" value="${board.title}">
		<input type="text" id="content" name="content" value="${board.content}">
		<!-- UserId  -->
		<select name="hobbyId">
			<option selected="selected">${board.hobbyId}</option>
			<option></option>								
		</select>
		<input type="submit" value="�����Ϸ�">

	</form>

</body>
</html>