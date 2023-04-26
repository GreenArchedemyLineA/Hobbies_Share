<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

		<div class="main">
			<div class="form-wrap">
				<div class="form-title">
					<h2>비밀번호 변경</h2>
				</div>
		
				<form action="/user/auth/updatePwd/${principal.id}" method="post">
		
					<div class="form-group">
						<label for="password">현재 비밀번호</label>
						<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="password">
					</div>
		
					<div class="form-group">
						<label for="newPwd">새 비밀번호</label>
						<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="newPwd">
					</div>
		
					<div class="form-group">
						<label for="checkPwd">비밀번호 확인&nbsp;&nbsp;</label>
						<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="checkPwd">
					</div>
		
					<button type="submit" class="btn btn-primary">비밀번호 수정</button>
					
				</form>
			</div>
		</div>
	</div>
	
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
