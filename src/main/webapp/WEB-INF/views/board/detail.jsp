<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/static/css/board.css">
<link rel="stylesheet" href="/static/css/detail.css">

<!-- <link rel="stylesheet" href="https://unpkg.com/mvp.css@1.12/mvp.css">  -->
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class="board-container">
	<%@ include file="/WEB-INF/views/board/layout/hobbyCategory.jsp"%>

	<div class="board-detail">
		<div class="board-detail-button">
			<a href="/board/hobbyList/${board.hobbyId}">${board.hobby.getName()}</a>
			<c:choose>
				<c:when test="${principal.id == board.userId}">
					<div>
						<a href="/board/update/${board.id}">수정</a>
						 <a href="/board/delete/${board.id}">삭제</a>
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<a href="/board/reportBoard/${board.id}">신고</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>



		<div>
			<div class="board-title">
				<h1>${board.title}</h1>
				<h4>${board.nickname}</h4> 
				<a href="/board/sendMsg/${board.userId}">쪽지보내기</a>
				${board.formatCreatedAt()}
			</div>
			<div class="board-content">${board.content}</div>	
		</div>


		
		<!--  댓글 -->
		<div class="board-comment">
		<h4>댓글</h4>
		<c:forEach var="comment" items="${comment}">
			<div class="board-detail-comment">
			<div><h5>${comment.nickname}</h5></div>
			<div>${comment.content}</div>
			<div>${comment.formatCreatedAt()}
				<c:choose>
					<c:when test="${principal.id == comment.userId}">
				
						<a href="/board/update-cmt/${comment.id}/${board.id}">수정</a>
						<a href="/board/delete-cmt/${comment.id}/${board.id}">삭제</a>
						</div></div>
			        </c:when>
			        <c:otherwise>
			        <a href="/board/reportCmt/${comment.id}">신고</a></div></div>
			        </c:otherwise>
	            </c:choose>
	    </c:forEach>
		</div>


	    <form action="/board/comment/${board.id}" method="post">
			<textarea id="mytextarea" name="content" cols="100" rows="5" placeholder="댓글작성해보세요"></textarea>
			<input type="submit" value="등록">
		</form>


		<!-- 글 + 댓글  -->
	</div>


</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
