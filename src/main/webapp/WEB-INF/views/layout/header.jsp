<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HOBBY-FI</title>
<link rel="shortcut icon" sizes="90x90" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/512/7081/7081314.png">
<link rel="stylesheet" href="/static/css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<div class="container">
		<div class="header">
			<div>
				<a href="/main/"><img src="/static/images/hobby-fi.png"></a>
			</div>
			<ul>
				<c:choose>
					<c:when test="${principal != null}">
						<li><a href="/user/auth/myPage"> <img alt="" src="<c:url value="${infoList.setUpUserImage()}"/>">
						</a></li>
						<li><a href="/user/auth/myPage">마이페이지</a></li>
						<li><a href="/user/auth/log-out">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/user/join-up">회원가입</a></li>
						<li><a href="/user/log-in">로그인</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>