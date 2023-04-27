<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/adminHeader.jsp" %>
	<c:choose>
		<c:when test="${QandA != null}">
			<table>
				<tr>
					<th></th>
					<th>내용</th>
				</tr>
			<c:forEach items="${QandA}" var="q_a" >
				<tr>
					<td>
						${q_a.id}
					</td>
					<td>
						<a href="question/${q_a.id}">${q_a.content}</a>
					</td>				
				</tr>
			</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			asdf
		</c:otherwise>
	</c:choose>
</body>
</html>