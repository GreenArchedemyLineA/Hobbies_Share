<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<link rel="stylesheet" href="/static/css/login.css">

<div class="main">
	<div class="form-wrap">
		<div class="form-title">
			<h2>로그인</h2>
		</div>

		<form action="/user/log-in" method="post">
			<c:if test="${not empty rememberCookie.getValue()}">
				<c:set value="checked" var="checked" />
			</c:if>
			<div class="email-pw-wrap">
				<div class="input-row" id="email-line">
					<div class="icon-cell" id="email-cell">
						<span class="icon-email"><span class="blind">이메일</span></span>
					</div>
					<input type="text" class="form-control" placeholder="이메일을 입력하세요" id="email" name="email" value="${rememberCookie.getValue()}">
				</div>

				<div class="input-row" id="pw-line">
					<div class="icon-cell" id="pw-cell">
						<span class="icon-pw"><span class="blind">비밀번호</span> </span>
					</div>
					<input type="password" class="form-control" placeholder="비밀번호" id="password" name="password">
				</div>
				<div class="login-keep-wrap">
					<input type="checkbox" class="keep" id="keep" name="keep" value="off"><label for="keep">로그인 상태 유지</label>
				</div>

				<div class="btn-login-wrap">
					<button type="submit" class="btn-login">
						<span class="btn-text">로그인</span>
					</button>
				</div>
			</div>

		</form>
	</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
