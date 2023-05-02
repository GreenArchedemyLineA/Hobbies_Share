<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/adminHeader.jsp"%>
<link rel="stylesheet" href="/static/css/adminAnswer.css">
<link rel="stylesheet" href="/static/css/manage.css">

<!-- 
	private Long id;
	private String email;
	private String password;
	private String username;
	private String phone; -->
<div class="answerContainer">
	<div class="blank"></div>
	<div>
		<div class="test">
			<form action="/main/usermanage/${id}" class="joinForm">
				<h2>회원 정보 수정</h2>
				<div class="textForm">
					<input name="id" type="text" class="id" placeholder="아이디" value="${user.id}">
				</div>
				<div class="textForm">
					<input name="password" type="password" class="pw" placeholder="비밀번호">
				</div>
				<div class="textForm">
					<input name="username" type="password" class="name" placeholder="이름" value="${user.username}">
				</div>
				<div class="textForm">
					<input name="email" type="text" class="email" placeholder="이메일" value="${user.email}">
				</div>
				<div class="textForm">
					<input name="phone" type="number" class="cellphoneNo" placeholder="전화번호" value="${user.phone}">
				</div>
				<div class="textForm" style="border:none;">
					<label>정지여부: </label>
					<select name="restriction">
						<option value = 0>이용가능</option> 
						<option value = 1>정지</option> 
					</select>
				</div>

				<input type="submit" class="btn" value="정보수정" />
			</form>
		</div>
	</div>
</div>
</body>
</html>