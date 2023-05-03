<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<link rel="stylesheet" href="/static/css/main.css">

<div class="main">
	<img src="/static/images/banner1.png" id="main">
</div>
<div class="whole-service">
	<div class="first-section">
		<div class="service-list" id="serviceContainer">
			<div class="guideContainer" id="boardContainer" onclick="goBoard()" style="cursor: pointer;">
				<img src="https://cdn-icons-png.flaticon.com/512/4698/4698381.png" width="30%">
				<div class="title">전체 게시글</div>
			</div>
			<div class="guideContainer">
				<div class="title">HobbyFi가 추천하는 유저</div>
			</div>
			<div class="guideContainer" style="cursor: pointer;" onclick="goQnA()">
				<img src="https://cdn-icons-png.flaticon.com/512/4698/4698167.png " width="30%">
				<div class="title">Q & A</div>
			</div>

		</div>
	</div>

	<div class="second-section">
		<div class="list-section">
			<div class="popular-list">
				<div class="title">인기 많은 유저</div>
				<c:forEach var="popularUser" items="${popularList}">
					<div onclick="findUser(${popularUser.user.id})" class="popularUserList">
						<img src="${popularUser.user.setUpUserImage()}"> <a>${popularUser.user.nickname}</a>
					</div>
				</c:forEach>
			</div>
			<div class="recent-post">
				<div class="title">최근 게시글</div>
				<c:forEach var="board" items="${boardList}">
					<div onclick="findBoard(${board.id})" class="popularBoardList">${board.title}</div>
				</c:forEach>
			</div>
		</div>
	</div>

</div>
</div>
<script type="text/javascript">
	function goBoard(){
		location.href="/board/list"
	}
							
	function goQnA() {
		location.href = "/main/Q_A";
	}

	const targetDiv = document.getElementById("serviceContainer");
	console.log(targetDiv.childNodes)
	
	function setUpUserImage(url){
		return url == null ? "https://cdn-icons-png.flaticon.com/512/3529/3529423.png"
			: "/images/uploads/" + url;
	}
	
	fetch("/recommend/id?id=${principal.id}",{
		method: "GET",
		headers: {
			"Content-Type": "application/json",
		},	 
	})
	.then((response) => response.json())
	.then((data)=>{
		data.map((obj)=>{
			if(obj.email !== "${principal.email}"){
				const divTag = document.createElement("div");
				divTag.classList.add('recommend')
				const aTag = document.createElement("a");
				aTag.innerText = obj.nickname;
				aTag.href="/user/auth/info/profile/"+obj.id
				const imgTag = document.createElement("img");
				imgTag.src = setUpUserImage(obj.uploadFileName);
				imgTag.width = "30";
				imgTag.height ="30";
				divTag.appendChild(imgTag);
				divTag.appendChild(aTag);
				targetDiv.childNodes[3].appendChild(divTag);
			}
		})				
	})
			
	function findUser(id){
		location.href = "/user/auth/info/profile/" + id;
	}
			
	function findBoard(id){
		location.href = "/board/detail/" + id;
	}
</script>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
