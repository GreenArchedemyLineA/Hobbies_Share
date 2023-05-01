<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	  
		<div class="main">
			<img src="/static/images/banner.png" id="main">
		</div>
		
		<div class="asidebar" id="asidebar">
			<div>
				<button onclick="onChangeAside()" id="hide-show">
					<span class="material-symbols-outlined"> chevron_right </span>
				</button>
			</div>
		
			<div class="aside" id="aside-recommend">
				<h3>HobbyFi가 추천하는 유저리스트</h3>
			</div>
		</div>
		<script>
		const targetDiv = document.getElementById("aside-recommend");
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
						 divTag.appendChild(aTag);
						 targetDiv.appendChild(divTag);
					 }
				 })
			 })
		</script>
		<div class="service">
			<div class="service-list">
				<div class="guideContainer" id="boardContainer" onclick="goBoard()">
					<img src="https://cdn-icons-png.flaticon.com/512/4698/4698381.png" width="30%">
					<div>게시글</div>
				</div>
				<div class="guideContainer">
					<div>기능2</div>
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
		<div>
			<img src="https://cdn.crowdpic.net/detail-thumb/thumb_d_2F583E5543F7E19139C6FCFFBF9607A6.jpg">
		</div>
		<canvas id="myChart" width="500" height="150"></canvas>
		<div class="nolja">유저들이 가진 가장 많은 취미 6개</div>
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
