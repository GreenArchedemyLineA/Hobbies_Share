<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div class="main">

	로그인

	<form action="/user/log-in" method="post">


		<div class="form-group">
			<label for="email">이메일 : </label>
			<input type="text" class="form-control" placeholder="이메일을 입력하세요" id="email" name="email">
		</div>

		<div class="form-group">
			<label for="password">비밀번호 : </label>
			<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" id="password" name="password">
		</div>

		<button type="submit" class="btn btn-primary">로그인</button>

	</form>
</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>