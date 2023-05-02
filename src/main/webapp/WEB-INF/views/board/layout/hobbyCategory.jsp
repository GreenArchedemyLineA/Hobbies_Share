<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div class="whole-board">
			<nav class="side-menu">
				<div class="side-menu-title">
					<b>취미 리스트</b>
				</div>
		
				<ul>
					<li><a href="/board/list" id="link">글전체조회</a></li>
					<c:forEach var="hobby" items="${hobbyList}">
						<c:choose>
							<c:when test="${hobby.id == id}">
								<li><a href="/board/hobbyList/${hobby.id}" class="selected" id="link">${hobby.hobby.getName()}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/board/hobbyList/${hobby.id}" class="notselected" id="link">${hobby.hobby.getName()}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</nav>