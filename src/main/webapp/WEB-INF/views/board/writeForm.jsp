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
	<h1>�Խñ۾���</h1>
	<form action="/board/write-proc" method="post">

		<input type="text" id="title" name="title" placeholder="�����̿�">
		<input type="text" id="content" name="content" placeholder="�����̿�">
		<!-- UserId  -->
		<select name="hobbyId">
			<!-- �׽�Ʈ�� -->
			<option>1</option>
			<option>2</option>
			<option>����</option>
			<option>��ȭ</option>
			<option>����</option>
			<option>���</option>
		</select> <input type="submit" value="���ε�">
	</form>

</body>
</html>