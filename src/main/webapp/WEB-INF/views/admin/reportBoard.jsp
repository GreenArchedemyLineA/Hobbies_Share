<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/adminHeader.jsp"%>
<link rel="stylesheet" href="/static/css/adminAnswer.css">
<link rel="stylesheet" href="/static/css/report.css">

<div class="answerContainer">
	<div class="blank"></div>
	<div class="report-table-wrap">
		<table class="report-table">
			<tr>
				<th>고객</th>
				<td>${user.username}님</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${board.content}</td>
			</tr>
		</table>
		<div class="check-btn">
			<form method="post">		
				<button>신고 확인</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>