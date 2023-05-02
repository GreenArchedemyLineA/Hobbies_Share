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
				<td>${question.content}</td>
			</tr>
		</table>
	</div>
	<div>
		<form action="/admin/main/user/${question.id}" method="post">
			<table>
				<tr>
					<td>답변 작성</td>
				</tr>
				<tr>
					<td style="display: flex; justify-content: center"><textarea cols="100" rows="30" id="answer" name="answer"></textarea></td>
				</tr>
			</table>
			<button type="submit" class="submitButton">답변</button>
		</form>
	</div>
</div>
<script>
	const answer = document.getElementById("answer");
	answer.innerHTML = "안녕하세요 고객님\n\n관리자 ${principal.username}입니다.\n\n"
			+ "{관리자의 답변을 작성하시면됩니다}\n\n"
			+ "저희 서비스를 계속 이용하시면서 불편한 점은 언제든지 Q & A를 통해 올리면 빠르게 답변드리겠습니다\n\n"
			+ "감사합니다."
</script>
</body>
</html>