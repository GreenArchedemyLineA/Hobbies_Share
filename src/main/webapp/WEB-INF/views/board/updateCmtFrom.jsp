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
	<a href="/board/update/${board.id}">수정하자구</a>
	<a href="/board/delete/${board.id}">삭제하자구</a>
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
					<c:choose>

						<c:when test="${comment.id == cid}">
							<td>
							<form action="/board/cmt-proc/${cid}/${board.id}" method="post">
								<input type="text" id="content" name="content" value="${comment.content}"> 
								<input type="submit" value="수정완료">
							</form>
							</td>

						</c:when>

						<c:otherwise>
							<td>${comment.content}</td>
						</c:otherwise>
					</c:choose>

					<td>${comment.userId}</td>
					<td>${comment.boardId}</td>
					<td>${comment.createdAt}</td>



					<c:choose>
						<c:when test="${principal.id == comment.userId}">
							<td><a href="#">본인</a></td>
							<td><a href="#">수정</a></td>
							<td><a href="#">삭제</a></td>
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>


		</tbody>
	</table>

	<form action="/board/comment/${board.id}" method="post">
		<input type="text" id="content" name="content">
		<!-- userId - 세션 -->
		<input type="submit" value="댓글적는디">
	</form>



</body>
</html>