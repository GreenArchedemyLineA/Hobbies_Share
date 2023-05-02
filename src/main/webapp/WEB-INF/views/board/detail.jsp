<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/static/css/board.css">
<link rel="stylesheet" href="/static/css/detail.css">

<!-- <link rel="stylesheet" href="https://unpkg.com/mvp.css@1.12/mvp.css">  -->
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<script type="text/javascript" src="/static/js/message.js"></script>

<div class="board-container">
	<%@ include file="/WEB-INF/views/board/layout/hobbyCategory.jsp"%>

	<div class="board-detail">
		<div class="board-detail-button">
			<a href="/board/hobbyList/${board.hobbyId}">${board.hobby.getName()}</a>
			<c:choose>
				<c:when test="${principal.id == board.userId}">
					<div>
						<a href="/board/update/${board.id}">수정</a> <a href="/board/delete/${board.id}">삭제</a>
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<a href="/board/reportBoard/${board.id}">신고</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>



		<div class="board-wrap">
			<div class="board-title">
				<h1>${board.title}</h1>
			</div>
			<div class="board-writer-info">
				<h4>${board.nickname}</h4>
				<a onclick="sendMsg_window(${board.userId})">쪽지보내기</a>
				<p>${board.formatCreatedAt()}</p>
			</div>
			<div class="board-content">${board.content}</div>
		</div>

		<!--  댓글 -->
		<div class="comment">
			<h4>댓글</h4>
			<div class="cmt-detail">
				<c:forEach var="comment" items="${comment}">
					<div class="cmt-nickname">
						<h5>${comment.nickname}</h5>
					</div>
					<div class="cmt-content">${comment.content}</div>
					<div class="cmt-info">
						<div class="cmt-createdAt">${comment.formatCreatedAt()}</div>
						<div class="cmt-manage">
							<c:choose>
								<c:when test="${principal.id == comment.userId}">
									<a href="/board/update-cmt/${comment.id}/${board.id}">수정</a>
									<a href="/board/delete-cmt/${comment.id}/${board.id}">삭제</a>
								</c:when>
								<c:otherwise>
									<a href="/board/reportCmt/${comment.id}">신고</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="cmt-writeform">
				<form action="/board/comment/${board.id}" method="post">
					<textarea id="mytextarea" name="content" cols="100" rows="5" placeholder="댓글작성해보세요"></textarea>
					<input type="submit" value="등록">
				</form>
			</div>
		</div>
	</div>
</div>

</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
