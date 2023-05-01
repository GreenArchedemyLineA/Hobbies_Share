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
				<h1>쪽지쪽지</h1>
			</div>
		
			<div class="profile-list">
				<div class="profile-img">
					<img alt="" src="<c:url value="${infoList.setUpUserImage()}"/>">
					<p>프로필 사진</p>
				</div>
				<div class="profile-info">
					<table>
						<tr>
							<th>이름</th>
							<td>${infoList.username}</td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td>${infoList.nickname}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${infoList.email}</td>
						</tr>
						<tr>
							<th>생일</th>
							<td>${infoList.formatBirth()}</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${infoList.formatPhone()}</td>
						</tr>
						<tr>
							<th>계정 생성일자</th>
							<td>${infoList.formatCreatedAt()}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>