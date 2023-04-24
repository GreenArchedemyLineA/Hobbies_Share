<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>회원 정보 수정</h2>

		<div>
			<form action="/user/update" method="post">
				<div class="form-group">
					<label for="email">이메일:</label> <input type="email"
						class="form-control" placeholder="사용할 이메일을 입력해주세요." id="email"
						name="email" value="${infoList.email}">
				</div>

				<div class="form-group">
					<label for="password">비밀번호:</label> <input type="password"
						class="form-control" placeholder="비밀번호를 입력해주세요" id="password"
						name="password" value="${infoList.password}">
				</div>

				<div class="form-group">
					<label for="username">이름:</label> <input type="text"
						class="form-control" placeholder="이름을 입력해주세요" id="username"
						name="username" value="${infoList.username}">
				</div>
				<div class="form-group">
					<label for="birth">생일:</label> <input type="text"
						class="form-control" id="birth" name="birth" value="${infoList.birth}"
						readonly="readonly">
				</div>
				<div class="form-group">
					<label for="phone">휴대폰 번호:</label> <input type="text"
						class="form-control" placeholder="휴대폰 번호를 입력해주세요" id="phone"
						name="phone" value="${infoList.phone}">
				</div>


				<button type="submit" class="btn btn-primary">정보 수정</button>

			</form>
		</div>
	</div>
</body>
</html>