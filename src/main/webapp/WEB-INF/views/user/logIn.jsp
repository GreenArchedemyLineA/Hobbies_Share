<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	�α���

	<form action="/user/log-in" method="post">


		<div class="form-group">
			<label for="email">�̸��� : </label>
			<input type="text" class="form-control" placeholder="�̸����� �Է��ϼ���" id="email" name="email" value="gildong@hobby.com">
		</div>

		<div class="form-group">
			<label for="password">��й�ȣ : </label>
			<input type="password" class="form-control" placeholder="��й�ȣ�� �Է��ϼ���" id="password" name="password" value="1234">
		</div>

		<button type="submit" class="btn btn-primary">�α���</button>

	</form>

</body>
</html>