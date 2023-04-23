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
	<h1>게시글 전체조회</h1>
	<a href="/board/write">글쓰자</a>
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
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.id}</td>
					<td><a href="/board/detail">${board.title}</a></td>
					<td>${board.content}</td>
					<td>${board.userId}</td>
					<td>${board.hobbyId}</td>
					<td>${board.createdAt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>