<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	  
		<div class="main">
			<img src="/static/images/banner.png" id="main">
		</div>
		
		<div class="service">
			<div class="service-list" id="serviceContainer">
				<div class="guideContainer" id="boardContainer" onclick="goBoard()">
					<img src="https://cdn-icons-png.flaticon.com/512/4698/4698381.png" width="30%">
					<div>게시글</div>
				</div>
				<div class="guideContainer">
					<div>HobbyFi가 추천하는 유저리스트</div>
				</div>
				<div class="guideContainer" style="cursor: pointer;" onclick="goQnA()">
					<img src="https://cdn-icons-png.flaticon.com/512/4698/4698167.png " width="30%">
					<div>Q & A</div>
				</div>
			
				<script type="text/javascript">
					function goBoard(){
						location.href="/board/list"
					}
					function goQnA() {
						location.href = "/main/Q_A";
					}
				</script>
			</div>
		</div>
		<script>
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
						 divTag.appendChild(imgTag);
						 divTag.appendChild(aTag);
						 targetDiv.childNodes[3].appendChild(divTag);
					 }
				 })
			 })
		</script>
		<div class="userlist">
			<div style="width:40vw; text-align:center;">
				<h2>인기많은 유저 리스트</h2>
				<c:forEach var="popularUser" items="${popularList}">
					<div style="display:flex; align-items:center;  justify-content:center;" onclick="findUser(${popularUser.user.id})">
						<img src="${popularUser.user.setUpUserImage()}" width="10%">
						<a>
							${popularUser.user.nickname}
						</a>
					</div>
				</c:forEach>
				<script>
					function findUser(id){
						location.href = "/user/auth/info/profile/" + id;
					}
				</script>
			</div>
			<div style="width:40vw; text-align:center;">
				<h2 style="width:40vw text-align:center;">최근에 쓴 글</h2>
				<c:forEach var="board" items="${boardList}">
					<div onclick = "findBoard(${board.id})" class="popularBoardList">${board.title}</div>
				</c:forEach>
				<script>
					function findBoard(id){
						location.href = "/board/detail/" + id;
					}
				</script>
			</div>
		</div>
		
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
