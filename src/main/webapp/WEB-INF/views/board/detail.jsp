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
	<h1>게시글 상세조회</h1>
	<a href="/board/update">수정하자구</a>
	<a href="/board/delete">삭제하자구</a>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>제목</th>
				<th>내용</th>
				<th>userId</th>
				<th>createdAt</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td><a href="#">제목이요</a></td>
				<td>상세내용이요상세</td>
				<td>나에요</td>
				<td>현재시간</td>
			</tr>
		</tbody>
	</table>

</body>
</html>