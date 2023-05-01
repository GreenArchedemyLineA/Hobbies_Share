<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<!-- <link rel="stylesheet" href="https://unpkg.com/mvp.css@1.12/mvp.css">  -->

		
		<div class="content">
			
         <%@ include file="/WEB-INF/views/board/layout/hobbyCategory.jsp"%>


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
						<c:forEach var="board" items="${boardList}">
							<tr>
								<td>${board.id}</td>
								<td>${board.hobby.getName()}</td>
								<td><a href="/board/detail/${board.id}">${board.title}</a></td>
								<td>${board.nickname}</td>
								<td>${board.formatCreatedAt()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>	