<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<!-- <link rel="stylesheet" href="https://unpkg.com/mvp.css@1.12/mvp.css">  -->



<%@ include file="/WEB-INF/views/board/layout/hobbyCategory.jsp"%>


<div class="board-list">

	<form action="/board/write" method="get">
		<button type="submit" class="write-btn">글쓰기</button>
	</form>

	<table class="styled-table">
		<thead>
			<tr>
				<th>NO</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.id}</td>
					<td><a href="/board/detail/${board.id}">${board.title}</a></td>
					<td>${board.nickname}</td>
					<td>${board.createdAt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
