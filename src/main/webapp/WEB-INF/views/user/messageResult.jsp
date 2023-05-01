<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${success == true}">
				<h1>쪽지 전송완료</h1>
			</c:when>
			<c:otherwise>
				<h1>쪽지 전송실패</h1>
			</c:otherwise>
		</c:choose>
		<button onclick="window.close()">확인</button>

	</div>
</body>
</html>