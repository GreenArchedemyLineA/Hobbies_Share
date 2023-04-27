<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<link rel="stylesheet" href="/static/css/board.css">
<link rel="stylesheet" href="/static/css/detail.css">
<!-- <link rel="stylesheet" href="https://unpkg.com/mvp.css@1.12/mvp.css">  -->





<div class="board">
	<%@ include file="/WEB-INF/views/board/layout/hobbyList.jsp"%>

	<div class="boardDetail-button">
		<c:choose>
			<c:when test="${principal.id == board.userId}">
				<a href="/board/update/${board.id}">수정</a>
				<a href="/board/delete/${board.id}">삭제</a>
				<a href="/board/list">글목록</a>
			</c:when>
			<c:otherwise>
				<a href="/board/list">글목록</a>
			</c:otherwise>
		</c:choose>
	</div>

	<table>

		<tbody>
			<tr>
				<td>title ${board.title}</td>
				<td>content ${board.content}</td>
				<td>${board.nickname}</td>
				<td>${board.hobby}</td>
				<td>${board.createdAt}</td>
			</tr>
		</tbody>
	</table>
	<br> <br>
	<h4>댓글</h4>
	
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>내용</th>
				<th>닉네임</th>
				<th>createdAt</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="comment" items="${comment}">
				<tr>
					<td>${comment.id}</td>
					<td>${comment.content}</td>
					<td>${comment.nickname}</td>
					<td>${comment.formatCreatedAt}</td>


					<c:choose>
						<c:when test="${principal.id == comment.userId}">
							<td>본인</td>
							<td><a href="/board/update-cmt/${comment.id}/${board.id}">수정</a></td>
							<td><a href="/board/delete-cmt/${comment.id}/${board.id}">삭제</a></td>
						</c:when>
						<c:otherwise>
							<td>본인만수정가능</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>


		</tbody>
	</table>

	<form action="/board/comment/${board.id}" method="post">
		<input type="text" id="content" name="content"> <input type="submit" value="댓글적는디">
	</form>


</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
