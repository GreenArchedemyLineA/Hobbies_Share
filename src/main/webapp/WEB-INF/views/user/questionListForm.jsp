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
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="questionList" items="${questionList}">
				<tr>
					<td>${questionList.id}</td>
					<td>${questionList.content}</td>
					<td>${questionList.formatName()}</td>
					<td>${questionList.proceed}</td>
					<td>${questionList.createdAt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>