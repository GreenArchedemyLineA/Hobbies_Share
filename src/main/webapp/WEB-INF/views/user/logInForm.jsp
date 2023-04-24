<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인

	<form action="/user/log-in" method="post">


		<div class="form-group">
			<label for="email">이메일 : </label>
			<input type="text" class="form-control" placeholder="이메일을 입력하세요" id="email" name="email" value="gildong@hobby.com">
		</div>

		<div class="form-group">
			<label for="password">비밀번호 : </label>
			<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" id="password" name="password" value="1234">
		</div>

		<button type="submit" class="btn btn-primary">로그인</button>

	</form>

</body>
</html>