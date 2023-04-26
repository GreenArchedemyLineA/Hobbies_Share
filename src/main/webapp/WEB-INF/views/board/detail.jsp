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
			<div class="aside">aside bar</div>


			<div class="board">

				<c:choose>
					<c:when test="${principal.id == board.userId}">
						<a href="/board/update/${board.id}">수정</a>
						<a href="/board/delete/${board.id}">삭제</a>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				<table>
					<thead>
						<tr>
							<th>id</th>
							<th>제목</th>
							<th>내용</th>
							<th>userId</th>
							<th>취미목록</th>
							<th>createdAt</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${board.id}</td>
							<td>${board.title}</td>
							<td>${board.content}</td>
							<td>${board.nickname}</td>
							<td>${board.hobby}</td>
							<td>${board.createdAt}</td>
						</tr>
					</tbody>
				</table>
				<br> <br>
				<h4>댓글</h4>
				<table>
					<thead>
						<tr>
							<th>id</th>
							<th>내용</th>
							<th>닉네임</th>
							<th>createdAt</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="comment" items="${comment}">
							<tr>
								<td>${comment.id}</td>
								<td>${comment.content}</td>
								<td>${comment.nickname}</td>
								<td>${comment.createdAt}</td>


								<c:choose>
									<c:when test="${principal.id == comment.userId}">
										<td>본인</td>
										<td><a href="/board/update-cmt/${comment.id}/${board.id}">수정</a></td>
										<td><a href="/board/delete-cmt/${comment.id}/${board.id}">삭제</a></td>
									</c:when>
									<c:otherwise>
										<td>본인만수정가능</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>


					</tbody>
				</table>

				<form action="/board/comment/${board.id}" method="post">
					<input type="text" id="content" name="content">
					<input type="submit" value="댓글적는디">
				</form>





			</div>
		</div>
	</div>
	<div class="footer">
		<div class="copyRight">&copy; GreenArchedemy A조 | Team Member: 김효린, 손주이, 이현서</div>
	</div>
</body>
</html>