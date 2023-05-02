<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/static/css/messageForm.css">



<div class="result-container">
	<div class="result-content">
		<c:choose>
			<c:when test="${success == true}">
				<h1>쪽지 전송 완료</h1>
			</c:when>
			<c:otherwise>
				<h1>쪽지 전송 실패</h1>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="confirm-btn">
		<button onclick="window.close()">확인</button>
	</div>
</div>
</body>
</html>