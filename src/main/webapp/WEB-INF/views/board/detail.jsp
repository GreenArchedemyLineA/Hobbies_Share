<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/static/css/detail.css">
<script type="text/javascript" src="/static/js/message.js"></script>

<!-- <link rel="stylesheet" href="https://unpkg.com/mvp.css@1.12/mvp.css">  -->
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/board/layout/hobbyCategory.jsp"%>

<div class="board-container">

	<div class="board-detail">
		<div class="board-detail-button">
			<div class="hobby-list-btn">
				<a href="/board/hobbyList/${board.hobbyId}">${board.hobby.getName()}</a>
			</div>
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
				<div class="board-owner">
					<img alt="" src="<c:url value="${board.setUpUserImage()}"/>">
					<div class="board-user-nickname">
						<p>${board.nickname}</p>
					</div>
					<div class="send-text">
						<a onclick="sendMsg_window(${board.userId})"><img src="https://cdn-icons-png.flaticon.com/512/7858/7858863.png"></a>
					</div>
				</div>
				<div class="board-created">
					<p>${board.formatCreatedAt()}</p>
				</div>
			</div>
			<div class="board-content">${board.content}</div>
		</div>

		<!--  댓글 -->
		<div class="comment">
			<h4>댓글</h4>
			<div class="cmt-wrap">
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
				<div class="nickname-tag">
					<p>${principal.nickname}</p>
				</div>
				<form action="/board/comment/${board.id}" method="post">
					<textarea id="mytextarea" name="content" cols="100" rows="5" placeholder="댓글작성해보세요" style="resize: none;"></textarea>
					<button type="submit" class=cmt-btn>등록</button>

				</form>
			</div>
		</div>
	</div>
</div>

</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
