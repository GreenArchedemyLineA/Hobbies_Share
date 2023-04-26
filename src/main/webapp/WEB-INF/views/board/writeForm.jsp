<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/static/css/style.css">
<link rel="stylesheet" href="/static/css/board.css">
<link rel="stylesheet" href="/static/css/editor.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
</head>
<body>
	<div class="container">
		<div class="header">
			<div>
				<a href="#"> <img src="https://plchldr.co/i/300x80">
				</a>
			</div>
			<ul>
				<li>회원가입</li>
				<li>로그인</li>
			</ul>
		</div>

		<div class="content-write">
			<form action="/board/write-proc" method="post">
				<input type="text" name="title" style="margin-bottom: 10px;" placeholder="제목을 입력해 주세요">
				
				<select name="hobbyId" >
						<option value="none">취미 카테고리</option>
					<c:forEach var="hobby" items="${hobbyList}">
						<option value="${hobby.id}">${hobby.hobby}</option>
					</c:forEach>
				</select>
				
				<textarea id="mytextarea" name="content" style="height: 60vh"></textarea>			
				
				<button type="submit" style="float: right; margin-top: 10px;">글쓰기</button>
			</form>
			
		</div>
	</div>
	<div class="footer">
		<div class="copyRight">&copy; GreenArchedemy A조 | Team Member: 김효린, 손주이, 이현서</div>
	</div>
	<script src="/static/js/editor.js"></script>
</body>
</html>