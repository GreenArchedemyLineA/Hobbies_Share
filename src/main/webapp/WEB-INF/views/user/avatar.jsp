<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>아바타 설정</h2>

		<div>
			<form action="/user/avatar" method="post">

				<div class="form-group">
					<label for="email">닉네임:</label> <input type="email" class="form-control" placeholder="사용할 별명을 입력해주세요." id="email" name="email" value="길동">
				</div>


				<div class="custom-file">
					<input type="file" class="custom-file-input" id="customFile" name="file" accept=".jpg, .jpeg, .png"> <label class="custom-file-label" for="customFile">Choose file</label>
				</div>

				<button type="submit" class="btn btn-primary">설정 완료</button>

			</form>
		</div>
	</div>

</body>
</html>