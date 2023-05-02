<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/static/css/message.css">


<div class="container">

	<div class="title-wrap">
		<%@ include file="/WEB-INF/views/user/layout/messageBar.jsp"%>

		<div class="title">
			<h1>받은 쪽지</h1>
		</div>

	</div>
	<div class="message-wrap">


		<div class="message-list">
			<table>
				<thead>
					<tr>
						<th>보낸사람</th>
						<th>쪽지</th>
						<th>전송시각</th>
					</tr>
				</thead>
				<c:forEach var="receive" items="${receiveList}">
					<tr>
						<td>${receive.nickname}</td>
						<td>${receive.message}</td>
						<td>${receive.formatCreatedAt()}</td>
					</tr>
				</c:forEach>

			</table>


		</div>


	</div>




</div>