<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class="board">

	<a href="/user/auth/write-question">글쓰기</a>

	<table class="styled-table">
		<thead>
			<tr>
				<th>NO</th>
				<th>내용</th>
				<th>작성자</th>
				<th>응답 현황</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="questionList" items="${questionList}">
				<tr>
					<td>${questionList.id}</td>
					<td><a href="/user/auth/update-question/${questionList.id}">${questionList.content}</a></td>
					<td>${questionList.formatName()}</td>
					<td>${questionList.proceed}</td>
					<td>${questionList.formatCreatedAt()}</td>
					<c:choose>
						<c:when test="${principal.id==questionList.userId}">
							<td><a href="/user/auth/delete-question/${questionList.id}">삭제</a></td>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>