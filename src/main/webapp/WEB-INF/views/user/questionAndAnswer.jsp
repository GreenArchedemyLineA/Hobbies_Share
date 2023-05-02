<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<div class="board">

	<form action="/user/auth/write-question" method="get">
		<button type="submit" class="write-btn">글쓰기</button>
	</form>

	<table class="styled-table">
		<thead>
			<tr>
				<th>내용</th>
				<th>응답 현황</th>
				<th colspan=2>작성일</th>
			</tr>  
		</thead>
		<tbody>
			<tr>
				<td>${resq.qandA.content}</td>
				<td>${resq.qandA.proceed}</td>
				<td>${resq.qandA.formatCreatedAt()}</td>
			</tr>
		</tbody>
	</table>

	<table class="styled-table">
		<thead>
			<tr>
				<th>답변</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${resq.answer.content}</td>
			</tr>
		</tbody>
	</table>

</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>