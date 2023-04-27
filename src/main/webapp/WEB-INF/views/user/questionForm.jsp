<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>


			<div class="board">

				<a href="/board/write">글쓰기</a>

				<table class="styled-table">
					<thead>
						<tr>
							<th>NO</th>
							<th>취미</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${questionList}">
							<tr>
								<td>${board.id}</td>
								<td>${board.hobby}</td>
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