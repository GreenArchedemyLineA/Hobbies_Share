<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

		<div class="main">
		
			<div class="menu-bar">
				<ul>
					<li><a href="/user/auth/info/profile/${userId}">프로필</a></li>
					<li><a href="/user/auth/info/write/${userId}">쓴 글</a></li>
					<li><a onclick="sendMsg_window(${userId})">쪽지보내기</a></li>
				</ul>
			</div>
		</div>
		
		<div class="write-wrap">
			<div class="profile">
				<h1>쓴 글</h1>
			</div>
		
			<div class="write-list">
				<table class="styled-table">
					<thead>
						<tr>
							<th>NO</th>
							<th>취미</th>
							<th>제목</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="writtenBoardList" items="${writtenBoardList}">
							<tr>
								<td>${writtenBoardList.id}</td>
								<td>${writtenBoardList.hobby.getName()}</td>
								<td><a href="/board/detail/${writtenBoardList.userId}">${writtenBoardList.title}</a></td>
								<td>${writtenBoardList.createdAt}</td>
							</tr>
						</c:forEach>
		
					</tbody>
				</table>
				<table class="styled-table">
					<thead>
						<tr>
							<th>NO</th>
							<th>내용</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="writtenCommentList" items="${writtenCommentList}">
							<tr>
								<td>${writtenCommentList.id}</td>
								<td><a href="/board/detail/${writtenCommentList.userId}">${writtenCommentList.content}</a></td>
								<td>${writtenCommentList.createdAt}</td>
							</tr>
						</c:forEach>
		
					</tbody>
				</table>
		
			</div>
		</div>
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>