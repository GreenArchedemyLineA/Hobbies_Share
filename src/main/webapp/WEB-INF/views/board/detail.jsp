<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<link rel="stylesheet" href="/static/css/board.css">
<link rel="stylesheet" href="/static/css/detail.css">
<link rel="stylesheet" href="/static/css/editor.css">
<!-- <link rel="stylesheet" href="https://unpkg.com/mvp.css@1.12/mvp.css">  -->





<div class="board-container">
	<%@ include file="/WEB-INF/views/board/layout/hobbyCategory.jsp"%>

	<div class="board-detail">
		<div class="board-detail-button">
			<c:choose>
				<c:when test="${principal.id == board.userId}">
					<a href="/board/update/${board.id}">수정</a>
					<a href="/board/delete/${board.id}">삭제</a>
					<a href="/board/list">글전체목록</a>
				</c:when>
				<c:otherwise>
					<a href="/board/list">글전체목록</a>

				</c:otherwise>
			</c:choose>
		</div>

		<h4>
			<a href="">${board.hobby.getName()}</a>
		</h4>


		<div>
			<div class="board-title">
				<h2>${board.title}</h2>
				<h5>${board.nickname}${board.formatCreatedAt()}</h5>
				${board.content}
			</div>


		</div>


		<br>
		<br>
		<!--  댓글 -->

		<table>


			<c:forEach var="comment" items="${comment}">
			
	
			
				<div><h5>${comment.nickname}</h5></div>
				<div>${comment.content}	</div>

				<div>
				 ${comment.formatCreatedAt()}
				
				<c:choose>
					<c:when test="${principal.id == comment.userId}">
										
					
						<a href="/board/update-cmt/${comment.id}/${board.id}">수정</a>
						<a href="/board/delete-cmt/${comment.id}/${board.id}">삭제</a>
						</div>
					</c:when>
					<c:otherwise>
						본인만수정가능</div>
					</c:otherwise>
				</c:choose>

			</c:forEach>


		
		</table>
		
		
		
		

		<form action="/board/comment/${board.id}" method="post">
			<textarea id="mytextarea" name="content" cols="50" rows="5" placeholder="댓글작성해보세요"></textarea>
			<input type="submit" value="등록">
		</form>


		<!-- 글 + 댓글  -->
	</div>


</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
