<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<link rel="stylesheet" href="/static/css/style.css">
<link rel="stylesheet" href="/static/css/board.css">
<link rel="stylesheet" href="/static/css/editor.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

<div class="container">


	<div class="content-write">
		<form action="/board/update-proc/${board.id}" method="post">
			<input type="text" name="title" style="margin-bottom: 10px;" value="${board.title}"> <select name="hobbyId">
				<option value="none">취미 카테고리</option>
				<c:forEach var="hobby" items="${hobbyList}">
					<c:choose>
						<c:when test="${board.hobby == hobby.hobby}">
							<option selected="selected" value="${hobby.id}">${hobby.hobby}</option>
						</c:when>
						<c:otherwise>
							<option value="${hobby.id}">${hobby.hobby}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>


			<textarea id="mytextarea" name="content" style="height: 60vh">
                	${board.content}
				</textarea>

			<button type="submit" style="float: right; margin-top: 10px;">수정</button>
		</form>

	</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
<script src="/static/js/editor.js"></script>
