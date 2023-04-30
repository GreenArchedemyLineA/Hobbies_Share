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
			 fetch("/recommend/age?id=${principal.getGeneration()}",{
				 method: "GET",
				 headers: {
					 "Content-Type": "application/json",
				 },	 
			 })
			 .then((response) => response.json())
			 .then((data)=>{
				 data.map((obj)=>{
					 console.log(obj)
					 if(obj.email !== "${principal.email}"){
						 const divTag = document.createElement("div");
						 divTag.classList.add('recommend')
						 const aTag = document.createElement("a");
						 aTag.innerText = obj.nickname;
						 aTag.href="#"
						 divTag.appendChild(aTag);
						 targetDiv.appendChild(divTag);
					 }
				 })
			 })
		</script>
		<div class="service">
			<div class="service-list">
				<div class="guideContainer" id="boardContainer">
					<div><a href="/board/list">게시글</a></div>
				</div>
				<div class="guideContainer">
					<div>기능2</div>
				</div>
				<div class="guideContainer" style="cursor: pointer;" onclick="goQnA()">
					<div>Q & A</div>
				</div>
			
				<script type="text/javascript">
					const boardContainer = document.getElementById("boardContainer");
					boardContainer.addEventListener("click", ()=>{
						location.href = "/board/list"
					})
					function goQnA() {
						location.href = "/main/Q_A";
					}
				</script>
			</div>
		</div>
		<div>
			<img src="https://cdn.crowdpic.net/detail-thumb/thumb_d_2F583E5543F7E19139C6FCFFBF9607A6.jpg"
			></div>
		<div class="nolja">취미를 같이 공유하자!</div>
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
