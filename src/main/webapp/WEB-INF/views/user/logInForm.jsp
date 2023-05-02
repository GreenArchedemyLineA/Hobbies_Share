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
<link rel="stylesheet" href="/static/css/login.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
</head>
<body>
	<div class="container">
		<div class="hobby-logo">
			<a href="/main/"><img src="/static/images/hobby-fi.png"></a>
		</div>

		<div class="main">
			<div class="login-wrap">
				<div class="form-title">
					<h2>로그인</h2>
				</div>
				<div class="email-pw-wrap">
					<form action="/user/log-in" method="post" class="login-form">

						<div class="input-row" id="email-line">
							<div class="icon-cell" id="email-cell">
								<span class="icon-email"><img alt="" src="https://cdn-icons-png.flaticon.com/512/4735/4735354.png"></span>
							</div>
							<input type="text" class="input-text" placeholder="이메일" id="email" name="email" value="${rememberCookie.getValue()}">
						</div>

						<div class="input-row" id="pw-line">
							<div class="icon-cell" id="pw-cell">
								<span class="icon-pw"><img alt="" src="https://cdn-icons-png.flaticon.com/512/7817/7817000.png"></span>
							</div>
							<input type="password" class="input-text" placeholder="비밀번호" id="password" name="password">
						</div>
						<div class="login-keep-wrap">
							<input type="checkbox" class="keep" id="keep" name="keep" value="off"><label for="keep">로그인 상태 유지</label>
						</div>
						<div class="join-btn">
							<a href="/user/join-up">회원가입</a>
						</div>
						<div class="btn-login-wrap">
							<button type="submit" class="btn-login">
								<span class="btn-text">로그인</span>
							</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>