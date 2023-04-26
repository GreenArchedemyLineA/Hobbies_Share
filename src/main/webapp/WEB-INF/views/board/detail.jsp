<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세조회</h1>

	<c:choose>
		<c:when test="${principal.id == board.userId}">
			<a href="/board/update/${board.id}">수정하자구</a>
			<a href="/board/delete/${board.id}">삭제하자구</a>
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
				<td>${board.userId}</td>
				<td>${board.hobbyId}</td>
				<td>${board.createdAt}</td>
			</tr>
		</tbody>
	</table>
	<br>
	<br>
	<h4>댓글</h4>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>내용</th>
				<th>userId</th>
				<th>boardId</th>
				<th>createdAt</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="comment" items="${comment}">
				<tr>
					<td>${comment.id}</td>
					<td>${comment.content}</td>
					<td>${comment.userId}</td>
					<td>${comment.boardId}</td>
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
</body>
</html>