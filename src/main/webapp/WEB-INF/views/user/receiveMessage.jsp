<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/static/css/message.css">


<div class="profile">
	<h1>받은 쪽지</h1>
</div>
<div class="main">

	<div class="menu-bar">
		<ul>
			<li><a href="/user/auth/select-S-msg">보낸쪽지</a></li>
			<li><a href="/user/auth/select-R-msg">받은쪽지</a></li>
		</ul>
	</div>
</div>

<div class="profile-wrap">

	<div class="profile-list">

		<div class="profile-info">

			<table>

				<tr>
					<th>보낸사람</th>
					<th>메세지</th>
					<th>보낸시간</th>

				</tr>
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
