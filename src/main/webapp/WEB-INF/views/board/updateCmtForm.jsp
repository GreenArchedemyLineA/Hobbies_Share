<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/static/css/board.css">
<link rel="stylesheet" href="/static/css/detail.css">

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class="board-container">
	<%@ include file="/WEB-INF/views/board/layout/hobbyCategory.jsp"%>

	<div class="board-detail">
		<div class="board-detail-button">
			<a href="/board/list">글목록</a>
			<c:choose>
				<c:when test="${principal.id == board.userId}">
					<div>
						<a href="/board/update/${board.id}">수정</a> <a href="/board/delete/${board.id}">삭제</a>
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</div>

		<div>
			<div class="board-title">
				<h1>${board.title}</h1>
				<h4>${board.nickname}</h4>${board.formatCreatedAt()}
			</div>
			<div class="board-content">${board.content}</div>
		</div>

		<div class="board-comment">
			<h4>댓글</h4>
			<c:forEach var="comment" items="${comment}">
				<div class="board-detail-comment">
					<div>
						<h5>${comment.nickname}</h5>
					</div>
					<c:choose>
						<c:when test="${comment.id == cid}">
							<form action="/board/cmt-proc/${cid}/${board.id}" method="post">
								<input type="text" id="content" name="content" value="${comment.content}"> <input type="submit" value="수정완료">
							</form>
						</c:when>

						<c:otherwise>
							<div>${comment.content}</div>
						</c:otherwise>
					</c:choose>

					<div>${comment.formatCreatedAt()}</div>
			</c:forEach>
			<!-- 글 + 댓글  -->
	

	</div>
	</div>

</div>
</div>


<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

