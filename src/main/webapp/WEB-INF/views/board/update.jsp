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
	<h1>게시글 수정</h1>
	<form action="#" method="post">

		<input type="text" id="title" name="title" value="제목이요">
		<input type="text" id="content" name="content" value="내용이요">
		<!-- UserId  -->
		<select>
			<option>맛집</option>
			<option>영화</option>
			<option>쇼핑</option>
			<option>취미</option>
		</select>

	</form>

</body>
</html>