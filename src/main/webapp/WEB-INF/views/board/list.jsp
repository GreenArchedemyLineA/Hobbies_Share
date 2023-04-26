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
<!-- <link rel="stylesheet" href="https://unpkg.com/mvp.css@1.12/mvp.css">  -->
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
		
		<div class="content">
			<div class="aside">
				<div>
					<div>취미 리스트</div>
					<div>
						<ul>
							<li><a href="#" class="selected" id="link">asdf</a></li>
							<li><a href="#" class="notselected" id="link">asdf</a></li>
							<li><a href="#" class="notselected" id="link">asdf</a></li>
							<li><a href="#" class="notselected" id="link">asdf</a></li>
							<li><a href="#" class="notselected" id="link">asdf</a></li>
							<li><a href="#" class="notselected" id="link">asdf</a></li>
							<li><a href="#" class="notselected" id="link">asdf</a></li>
							<li><a href="#" class="notselected" id="link">asdf</a></li>
							<li><a href="#" class="notselected" id="link">asdf</a></li>
						</ul>
					</div>
				</div>
			</div>


			<div class="board">

				<a href="/board/write">글쓰기</a>

				<table class="styled-table">
					<thead>
						<tr>
							<th>NO</th>
							<th>취미</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${boardList}">
							<tr>
								<td>${board.id}</td>
								<td>${board.hobby}</td>
								<td><a href="/board/detail/${board.id}">${board.title}</a></td>
								<td>${board.nickname}</td>
								<td>${board.createdAt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	<div class="footer">
		<div class="copyRight">&copy; GreenArchedemy A조 | Team Member: 김효린, 손주이, 이현서</div>
	</div>
</body>
</html>