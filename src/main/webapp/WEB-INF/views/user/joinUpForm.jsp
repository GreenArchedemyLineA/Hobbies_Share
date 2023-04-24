<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>회원가입</h2>

		<div>
			<form action="/user/join-up" method="post">

				<div class="form-group">
					<label for="email">이메일:</label>
					<input type="email" class="form-control" placeholder="사용할 이메일을 입력해주세요." id="email" name="email" value="gildong@hobby.com">
				</div>

				<div class="form-group">
					<label for="password">비밀번호:</label>
					<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="password" name="password" value="1234">
				</div>

				<div class="form-group">
					<label for="username">이름:</label>
					<input type="text" class="form-control" placeholder="이름을 입력해주세요" id="username" name="username" value="고길동">
				</div>

				<div class="form-group">
					<label for="nickname">닉네임:</label>
					<input type="text" class="form-control" placeholder="사용할 닉네임을 입력해주세요" id="nickname" name="nickname" value="길동이 아죠씨">
				</div>

				<div class="form-group">
					<label for="birth">생일:</label>
					<input type="text" class="form-control" id="birth" name="birth" value="1956-11-18">
				</div>
				<div class="form-group">
					<label for="phone">휴대폰 번호:</label>
					<input type="text" class="form-control" placeholder="휴대폰 번호를 입력해주세요" id="phone" name="phone" value="01011111111">			
				</div>
				

				<button type="submit" class="btn btn-primary">회원가입</button>

			</form>
		</div>
	</div>

</body>
</html>