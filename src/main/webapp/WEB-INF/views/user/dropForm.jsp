<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>>

		<div class="main">
			<div class="form-wrap">
				<div class="form-title">
					<h2>회원 탈퇴</h2>
				</div>
		
				<form action="/user/auth/drop" method="post">
		
					<div class="form-group">
						<label for="email">이메일</label>
						<input type="text" class="form-control" placeholder="이메일을 입력하세요" id="email" name="email">
					</div>
		
					<div class="form-group">
						<label for="password">비밀번호&nbsp;&nbsp;</label>
						<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="password">
					</div>
		
					<button type="submit" class="btn btn-primary">회원 탈퇴</button>
		
				</form>
			</div>
		</div>
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
