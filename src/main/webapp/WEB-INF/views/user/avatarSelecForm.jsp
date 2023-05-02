<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="main">
	<div class="form-wrap">
		<div class="form-title">
			<h2>프로필 수정</h2>
		</div>

		<form action="/user/auth/avatarSelec/${principal.id}" method="post" enctype="multipart/form-data">

			<div class="form-group">
				<label for="nickname">닉네임</label> <input type="text" class="form-control" id="nickname" name="nickname" value="${infoList.nickname}">
			</div>

			<div class="custom-file">
				<label for="customFile">사진 선택&nbsp;&nbsp;</label> <input type="file" class="custom-file-input" id="customFile" name="file" accept=".jpg, .jpeg, .png"> <label class="custom-file-label"
					for="customFile">&nbsp;사진 선택</label>
			</div>

			<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
			<script>
				// Add the following code if you want the name of the file appear on select
				$(".custom-file-input").on(
						"change",
						function() {
							var fileName = $(this).val().split("\\").pop();
							$(this).siblings(".custom-file-label").addClass(
									"selected").html(fileName);
						});
			</script>
			<div class="btn-setting-wrap">
				<button type="submit" class="btn-setting">
					<span class="btn-text">설정 완료</span>
				</button>
			</div>
		</form>
	</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>