<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/adminHeader.jsp" %>
<link rel="stylesheet" href="/static/css/adminAnswer.css">

<div class="answerContainer">
<div class="blank">
</div>
	<div>
		<table>
			<tr>
				<th>고객</th>
				<td>${user.username}님</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${comment.content}</td>
			</tr>
		</table>
	</div>
<button>신고 확인</button>
</div>
</body>
</html>