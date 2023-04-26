<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="main"></div>
<div class="form-wrap">
	<h2>아바타 설정</h2>

	<div calss="form">
		<form action="/user/auth/avatarSelec/${principal.id}" method="post" enctype="multipart/form-data">

			<div class="form-group">
				<label for="nickname">닉네임:</label> <input type="text" class="form-control" id="nickname" name="nickname" value="${infoList.nickname}">
			</div>


			<div class="custom-file">
				<input type="file" class="custom-file-input" id="customFile" name="file" accept=".jpg, .jpeg, .png">${infoList.originFileName}<label class="custom-file-label" for="customFile">Choose
					file</label>
			</div>

			<button type="submit" class="btn btn-primary">설정 완료</button>

		</form>
	</div>
</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>