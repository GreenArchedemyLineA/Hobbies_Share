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
	<h1>�Խñ� ����ȸ</h1>
	<a href="/board/update/${board.id}">�������ڱ�</a>
	<a href="/board/delete/${board.id}">�������ڱ�</a>
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

</body>
</html>