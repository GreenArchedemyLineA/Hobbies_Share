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
	<h1>�Խñ� ��ü��ȸ</h1>
	<a href="/board/write">�۾���</a>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>����</th>
				<th>����</th>
				<th>userId</th>
				<th>��̸��</th>
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