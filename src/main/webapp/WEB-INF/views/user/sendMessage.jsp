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
				<h1>보낸 쪽지</h1>
			</div>
		
			<div class="profile-list">
				<div class="profile-img">
					<img alt="" src="<c:url value=""/>">
					<p>프로필 사진</p>
				</div>
				<div class="profile-info">
					<table>
						<tr>
							<th>이름</th>
							<td></td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td></td>
						</tr>
						<tr>
							<th></td>
						</tr>
		
					</table>
				</div>
			</div>
		</div>
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>