<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/adminAnswer.css">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	width: 100%;
	height: 100%;
}

.error {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100%;
}

.error-img {
	display: flex;
	justify-content: center;
}

.error-img img {
	height: 400px;
	margin: 0 -30px;
}

.error-msg p:first {
	display: flex;
	flex-direction: column;
	justify-content: center;
	font-weight: bold;
	font-size: 50px;
}
</style>
</head>
<body>

	<div class="error">
		<div class="error-img">
			<img alt="4" src="https://cdn-icons-png.flaticon.com/512/4020/4020013.png"> <img alt="0" src="https://cdn-icons-png.flaticon.com/512/4020/4020019.png"> <img alt="4"
				src="https://cdn-icons-png.flaticon.com/512/8973/8973420.png">

		</div>

		<div class="error-msg">

			<h1>페이지를 찾을 수 없습니다.</h1>
			<p>원하시는 결과를 찾을 수 없습니다.</p>
			<p>올바른 URL을 입력하였는지 확인해주세요. 자세한 내용은 사이트 관리자에게 문의하시기 바랍니다.</p>

			<a href="/main/">메인 페이지로 이동</a> <a href="/main/Q_A">문의하기</a>

		</div>

	</div>
</body>
</html>