<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>

<body>
	<div class="container">
		<div class="header">
			<div>
				<a href="#"> <img src="https://plchldr.co/i/300x80">
				</a>
			</div>
			<ul>
				<li>회원가입</li>
				<li>로그인</li>
			</ul>
		</div>
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
					<a href="#">asdfaaaaaaaaaaaaaaaaa</a>
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
	<div class="footer">
		<div class="copyRight">&copy; GreenArchedemy A조 | Team Member: 김효린, 손주이, 이현서</div>
	</div>
	<script src="imgLoad.js"></script>
	<script>
		function onChangeAside() {
			const divElement = document.getElementById("aside-recommend");
			const button = document.getElementById("hide-show")
			if (divElement.className === 'aside') {
				divElement.classList.remove('aside')
				divElement.classList.add('aside-hidden')
				button.childNodes[1].innerText = "chevron_left"

			} else {
				divElement.classList.remove('aside-hidden')
				divElement.classList.add('aside')
				button.childNodes[1].innerText = "chevron_right"
			}
		}
	</script>
	<script>
		// const recommendElement = document.createElement("div");
		// recommendElement.innerText = "ㅇㅇㅇㅇ"
		// const recommendElement2 = document.createElement("div");
		// recommendElement2.innerText = "ㅁㅁㅁㅁ"
		// const divElement = document.getElementById("aside-recommend");
		// divElement.appendChild(recommendElement)
		// divElement.appendChild(recommendElement2)
	</script>
</body>
</html>