<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

		<div class="main">
			<img src="https://plchldr.co/i/1920x400" id="main">
		</div>
		
		<div class="asidebar" id="asidebar">
			<div>
				<button onclick="onChangeAside()" id="hide-show">
					<span class="material-symbols-outlined"> chevron_right </span>
				</button>
			</div>
		
			<div class="aside" id="aside-recommend">
				<h3>추천</h3>
				<div class="recommend">
					<a href="#">뭘 띄어야하낭</a>
				</div>
				<div class="recommend">
					<a href="#">엥??</a>
				</div>
				<div class="recommend">
					<a href="#">asdf</a>
				</div>
				<div class="recommend">
					<a href="#">asdf</a>
				</div>
				<div class="recommend">
					<a href="#">asdf</a>
				</div>
				<div class="recommend">
					<a href="#">asdf</a>
				</div>
				<div class="recommend">
					<a href="#">asdf</a>
				</div>
				<div class="recommend">
					<a href="#">asdf</a>
				</div>
				<div class="recommend">
					<a href="#">asdf</a>
				</div>
				<div class="recommend">
					<a href="#">asdf</a>
				</div>
			</div>
		</div>
		
		<div class="service">
			<div class="service_list">
				<div class="guideContainer">
					<div>기능1</div>
				</div>
				<div class="guideContainer">
					<div>기능2</div>
				</div>
				<div class="guideContainer">
					<div>Q & A</div>
				</div>
			</div>
		</div>
		
		<div class="nolja">취미를 같이 공유하자!</div>
	</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
