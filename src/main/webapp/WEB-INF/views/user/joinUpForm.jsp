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
<script type="text/javascript" src="/static/js/event.js"></script>
<script type="text/javascript" src="/static/js/validation.js"></script>
</head>
<body>
	<div class="container">
		<div class="hobby-logo">
			<a href="/main/"><img src="/static/images/hobbyfi.png"></a>
		</div>

		<div class="main">
			<div class="joinup-wrap">
				<div class="form-title">
					<h2>회원가입</h2>
				</div>

				<div class="info-wrap">

					<form action="/user/join-up" method="post" class="joinup-form">

						<div class="input-row" id="email-line">
							<label for="email">이메일</label> <input type="email" class="input-text" placeholder="사용할 이메일을 입력해주세요" id="email" name="email">
							<button class="checker" id="emailChecker" type="button">중복 확인</button>
						</div>

						<div class="input-row" id="pw-line">
							<label for="password">비밀번호</label> <input type="password" class="input-text" placeholder="비밀번호를 입력해주세요" id="password" name="password">
						</div>

						<div class="input-row" id="uname-line">
							<label for="username">이름</label> <input type="text" class="input-text" placeholder="이름을 입력해주세요" id="username" name="username">
						</div>

						<div class="input-row" id="unickname-line">
							<label for="nickname">닉네임</label> <input type="text" class="input-text" placeholder="사용할 닉네임을 입력해주세요" id="nickname" name="nickname">
							<button class="checker" id="nicknameChecker" type="button">중복 확인</button>
						</div>

						<div class="input-row" id="birth-line">
							<label for="birth">생일</label> <input type="date" class="input-text" id="birth" name="birth">
						</div>

						<div class="input-row" id="phone-line">
							<label for="phone">휴대폰 번호&nbsp;&nbsp;</label> <input type="text" class="input-text" placeholder="휴대폰 번호를 하이픈('-') 없이 입력해주세요" id="phone" name="phone" oninput="onlyNumber()">
						</div>

						<div class="btn-joinup-wrap">
							<button type="submit" class="btn-joinup">
								<span class="btn-text">로그인</span>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>