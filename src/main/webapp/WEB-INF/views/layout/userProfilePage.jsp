<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

		<div class="main">
		
			<div class="menu-bar">
				<ul>
					<li><a href="/user/auth/info/profile/${otherUserInfo.id}">프로필</a></li>
					<li><a href="/user/auth/info/write/${otherUserInfo.id}">쓴 글</a></li>
					<li><a onclick="sendMsg_window(${otherUserInfo.id})">쪽지보내기</a></li>
				</ul>
			</div>
		</div>
		
		<div class="profile-wrap">
			<div class="profile">
				<h1>개인 정보</h1>
			</div>
		
			<div class="profile-list">
				<div class="profile-img">
					<img alt="" src="<c:url value="${otherUserInfo.setUpUserImage()}"/>">
					<p>프로필 사진</p>
				</div>
				<div class="profile-info">
					<table>
						<tr>
							<th>이름</th>
							<td>${otherUserInfo.username}</td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td>${otherUserInfo.nickname}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${otherUserInfo.email}</td>
						</tr>
						<tr>
							<th>생일</th>
							<td>${otherUserInfo.formatBirth()}</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${otherUserInfo.formatPhone()}</td>
						</tr>
						<tr>
							<th>계정 생성일자</th>
							<td>${otherUserInfo.formatCreatedAt()}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>