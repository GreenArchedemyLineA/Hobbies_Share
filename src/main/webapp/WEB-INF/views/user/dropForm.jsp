<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form action="/user/auth/drop" method="post">


			<div class="form-group">
				<label for="password">비밀번호:</label>
				<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="password" value="1234">
			</div>



			<button type="submit" class="btn btn-primary">회원 탈퇴</button>

		</form>
	</div>


</body>
</html>