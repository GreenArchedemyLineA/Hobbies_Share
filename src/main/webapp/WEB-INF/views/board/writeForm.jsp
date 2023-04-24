<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글쓰기</h1>
	<form action="/board/write-proc" method="post">

		<input type="text" id="title" name="title" placeholder="제목이요">
		<input type="text" id="content" name="content" placeholder="내용이요">
		<!-- UserId  -->
		<select name="hobbyId">
			<!-- 테스트용 -->
			<option>1</option>
			<option>2</option>
			<option>맛집</option>
			<option>영화</option>
			<option>쇼핑</option>
			<option>취미</option>
		</select> <input type="submit" value="업로드">
	</form>

</body>
</html>