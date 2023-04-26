<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="footer">
	<div class="copyRight">&copy; GreenArchedemy A조 | Team Member: 김효린, 손주이, 이현서</div>
</div>
<script src="/static/js/imgLoad.js"></script>
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