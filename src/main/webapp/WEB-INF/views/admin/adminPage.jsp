<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/adminHeader.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="main">
<div class="blank">
</div>
	<c:choose>
		<c:when test="${userList != null}">
			<table class="styled-table">
			<thead>
				<tr>
					<th>번호</th>
					<th>고객이름</th>
					<th>닉네임</th>
				</tr>
			</thead>
			<c:forEach items="${userList}" var="user" >
				<tr onclick="goUser(${user.id})">
					<td>
						${user.id}
					</td>
					<td>
						${user.username}
					</td>
					<td>
						${user.nickname}
					</td>		
				</tr>
			</c:forEach>
			<script>
				function goUser(id){
					location.href = '/admin/main/user/'+id;
				}
			</script>
			</table>
		</c:when>
		<c:when test="${QandA != null}">
		<div class="table-Q">
			<table class="styled-table">
			<thead>
				<tr>
					<th>번호</th>
					<th>내용</th>
				</tr>
			</thead>
			<c:forEach items="${QandA}" var="q_a" >
				<tr>
					<td>
						${q_a.id}
					</td>
					<td>
						<a href="main/question/${q_a.id}">${q_a.content}</a>
					</td>				
				</tr>
			</c:forEach>
			</table>
		</div>
		<div class="pageNation">
			<ul>			
				<c:if test="${startPage != 1}">
					<li><span class="material-symbols-outlined"><a href="/admin/main?checkId=2&boardId=${endPage-10}">chevron_left</a></span></li>
				</c:if>
				<c:if test="${startPage == 1}">
					<li><span class="material-symbols-outlined">chevron_left</span></li>
				</c:if>
					<c:forEach begin="${startPage}" end="${endPage}" var="page">
						<c:choose>
							<c:when test="${page == boardId}">
								<li class="currentPage"><a href="/admin/main?checkId=2&boardId=${page}">${page}</a>
							</c:when>
							<c:otherwise>
								<li><a href="/admin/main?checkId=2&boardId=${page}">${page}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				<c:if test="${endPage == size}">
					<li><span class="material-symbols-outlined">chevron_right</span></li>
				</c:if>	
				<c:if test="${endPage != size}">
					<li><span class="material-symbols-outlined"><a href="/admin/main?checkId=2&boardId=${startPage+10}">chevron_right</a></span></li>
				</c:if>
			</ul>
		</div>
		</c:when>
		<c:otherwise>
			asdf
		</c:otherwise>
	</c:choose>

</div>
</div>
</body>
</html>