<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/user/auth/updatePwd/${principal.id}" method="post">



		<div class="form-group">
			<label for="password">현재 비밀번호:</label> <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="password">
		</div>



		<div class="form-group">
			<label for="newPwd">새 비밀번호:</label> <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="newPwd">
		</div>

		<div class="form-group">
			<label for="checkPwd">새 비밀번호 확인:</label> <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="checkPwd">
		</div>

		<button type="submit" class="btn btn-primary">비밀번호 수정</button>
	</form>


</body>
</html>