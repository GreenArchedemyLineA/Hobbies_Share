<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="content-write">
	<form action="/user/auth/write-question" method="post">


		<textarea id="mytextarea" name="content" style="height: 60vh" placeholder="문의하실 내용을 입력해주세요."></textarea>

		<button type="submit" style="float: right; margin-top: 10px;">글쓰기</button>
	</form>

</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
<script src="/static/js/editor.js"></script>
