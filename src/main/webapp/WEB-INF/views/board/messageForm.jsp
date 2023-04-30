<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<link rel="stylesheet" href="/static/css/editor.css">
<div>
	<div>받는 사람 : ${user.nickname}</div>
	<form action="/board/send-Proc/${userId}" method="post">
		<input type="text" name="message">
		<input type="submit" value="보내기">
	</form>
	
	
</div>
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
