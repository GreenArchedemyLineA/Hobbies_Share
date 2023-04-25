<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOBBY-FI</title>
</head>
<body>
	<div class="body-skin">
		<div class="">
			<c:choose>
				<c:when test="${principal != null}">
					<a href="/user/auth/avatarSelec/${principal.id}">프로필 수정</a>
					<a href="/user/auth/update/${principal.id}">회원 정보 수정</a>
					<a href="/user/auth/updatePwd/${principal.id}">비밀 번호 변경</a>
					<a href="/user/auth/log-out">로그아웃</a>
					<a href="/user/auth/drop/${principal.id}">회원 탈퇴</a>
				</c:when>
				<c:otherwise>
					<a href="/user/join-up">회원가입</a>
					<a href="/user/log-in">로그인</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div>
		<div>
			<c:choose>
				<c:when test="${principal != null}">
					<img alt="" src="<c:url value="${principal.setUpUserImage()}"/>">
				</c:when>
				<c:otherwise>
					<div></div>
				</c:otherwise>

			</c:choose>

		</div>

		<div class="front-banner">배너사진</div>
		<div>내용물</div>


	</div>
</body>
</html>