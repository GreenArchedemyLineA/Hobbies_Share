<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>ȸ������</h2>

		<div>
			<form action="/user/join-up" method="post">

				<div class="form-group">
					<label for="email">�̸���:</label>
					<input type="email" class="form-control" placeholder="����� �̸����� �Է����ּ���." id="email" name="email" value="gildong@hobby.com">
				</div>

				<div class="form-group">
					<label for="password">��й�ȣ:</label>
					<input type="password" class="form-control" placeholder="��й�ȣ�� �Է����ּ���" id="password" name="password" value="1234">
				</div>

				<div class="form-group">
					<label for="username">�̸�:</label>
					<input type="text" class="form-control" placeholder="�̸��� �Է����ּ���" id="username" name="username" value="��浿">
				</div>
				<div class="form-group">
					<label for="birth">����:</label>
					<input type="text" class="form-control" id="birth" name="birth" value="1956-11-18">
				</div>
				<div class="form-group">
					<label for="phone">�޴��� ��ȣ:</label>
					<input type="text" class="form-control" placeholder="�޴��� ��ȣ�� �Է����ּ���" id="phone" name="phone" value="01011111111">			
				</div>
				

				<button type="submit" class="btn btn-primary">ȸ������</button>

			</form>
		</div>
	</div>

</body>
</html>