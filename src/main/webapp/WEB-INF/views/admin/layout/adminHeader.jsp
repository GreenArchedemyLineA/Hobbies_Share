<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/admin.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<div class = container>
	<div class="header">
		<div class="logo">
			<a href="main">Hobby-Fi 관리자 페이지</a>
		</div>
		<ul>
			<li><a href="/admin/main?checkId=1">유저관리</a></li>
			<li><a href="/admin/main?checkId=2">Q & A 확인</a></li>
			<li><a href="/admin/main?checkId=3">신고글 확인</a>
			<li><a href="/admin/main?checkId=4">신고댓글 확인</a></li>
			<li><a href="/admin/logout"><span class="material-symbols-outlined">logout</span></a></li>
		</ul>
	</div>
