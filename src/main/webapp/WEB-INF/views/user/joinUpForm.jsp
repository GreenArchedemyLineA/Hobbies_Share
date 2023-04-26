<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="main">
	<div class="form-wrap">
		<div class="form-title">
			<h2>회원가입</h2>
		</div>

		<form action="/user/join-up" method="post">

			<div class="form-group">
				<label for="email">이메일</label> <input type="email" class="form-control" placeholder="사용할 이메일을 입력해주세요" id="email" name="email">
			</div>

			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="password">
			</div>

			<div class="form-group">
				<label for="username">이름</label> <input type="text" class="form-control" placeholder="이름을 입력해주세요" id="username" name="username">
			</div>

			<div class="form-group">
				<label for="nickname">닉네임</label> <input type="text" class="form-control" placeholder="사용할 닉네임을 입력해주세요" id="nickname" name="nickname">
			</div>

			<div class="form-group">
				<label for="birth">생일</label> <input type="date" class="form-control" id="birth" name="birth">
			</div>
			<div class="form-group">
				<label for="phone">휴대폰 번호 &nbsp;&nbsp;</label> <input type="text" class="form-control" placeholder="휴대폰 번호를 입력해주세요" id="phone" name="phone">
			</div>

			<button type="submit" class="btn btn-primary">회원가입</button>

		</form>

	</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>