<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class="board">

	<form action="/user/auth/write-question" method="get">
		<button type="submit" class="write-btn">글쓰기</button>
	</form>

	<table class="styled-table">
		<thead>
			<tr>
				<th>NO</th>
				<th>내용</th>
				<th>작성자</th>
				<th>응답 현황</th>
				<th colspan=2>작성일</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="questionList" items="${questionList}">
				<tr>
					<td>${questionList.id}</td>
					<c:choose>
						<c:when test="${questionList.proceed} == 0">
							<td><a href="/user/auth/update-question/${questionList.id}">${questionList.content}</a></td>
						</c:when>
						<c:otherwise>
							<td><a href="/user/auth/questionDetail/${questionList.id}">${questionList.content}</a></td>
						</c:otherwise>
					</c:choose>
					<td>${questionList.formatName()}</td>
					
					<td>${questionList.proceed}</td>
					<td>${questionList.formatCreatedAt()}</td>
					<td><a href="/user/auth/delete-question/${questionList.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>