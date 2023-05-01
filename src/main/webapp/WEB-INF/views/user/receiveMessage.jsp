<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<div class="main">

	<div class="menu-bar">
		<ul>
			<li><a href="/user/auth/select-S-msg">보낸쪽지</a></li>
			<li><a href="/user/auth/select-R-msg">받은쪽지</a></li>
		</ul>
	</div>
</div>

<div class="profile-wrap">
	<div class="profile">
		<h1>받은 쪽지</h1>
	</div>

	<div class="profile-list">
		<div class="profile-img">
			<img alt="" src="<c:url value=""/>">
			<p>프로필 사진</p>
		</div>
		<div class="profile-info">

			<table>

				<c:forEach var="receive" items="${receiveList}">
					<tr>
						<th>보낸사람</th>
						<td>${receive.nickname}</td>
					</tr>
					<tr>
						<th>메세지</th>
						<td>${receive.message}</td>
					</tr>
					<tr>
						<th>보낸시간</th>
						<td>${receive.formatCreatedAt()}</td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>
</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>