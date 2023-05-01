<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/static/css/message.css">


<div class="container">
	<div class="title-wrap">
		<%@ include file="/WEB-INF/views/user/layout/messageBar.jsp"%>
		<div class="title">
			<h1>전체 쪽지</h1>
		</div>

	</div>
	<div class="message-wrap">


		<div class="message-list">
			<table>
				<tr>
					<th>보낸 사람</th>
					<th>받는 사람</th>
					<th>쪽지</th>
					<th>전송시각</th>
				</tr>
				<c:forEach var="all" items="${allList}">
					<tr>
						<td>${all.senderNickname}</td>
						<td>${all.receiverNickname}</td>
						<td>${all.message}</td>
						<td>${all.formatCreatedAt()}</td>
					</tr>
				</c:forEach>
			</table>


		</div>


	</div>




</div>