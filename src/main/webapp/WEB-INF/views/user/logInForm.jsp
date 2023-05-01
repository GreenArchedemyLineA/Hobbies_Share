<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="main">
	<div class="form-wrap">
		<div class="form-title">
			<h2>로그인</h2>
		</div>

		<form action="/user/log-in" method="post">
			<c:if test="${not empty rememberCookie.getValue()}">
				<c:set value="checked" var="checked" />
			</c:if>

			<div class="form-group">
				<label for="email">이메일</label> <input type="text" class="form-control" placeholder="이메일을 입력하세요" id="email" name="email" value="${rememberCookie.getValue()}">
			</div>

			<div class="form-group">
				<label for="password">비밀번호&nbsp;&nbsp;</label> <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" id="password" name="password">
			</div>

			<div>
				<input type="checkbox" id="remember" name="remember" value="true" ${checked}><label for="remember">이메일 기억하기</label>
			</div>

			<button type="submit" class="btn btn-primary">로그인</button>

		</form>
	</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
