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
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
	function addZero(i) {
		var rtn = i + 100;
		return rtn.toString().substr(1, 3);
	}

	var monthList = [];
	var monthData = [50,60,70,45,50,66];

	var dt = new Date();
	var year = dt.getFullYear();
	var mon = addZero(eval(dt.getMonth()+1));		
	var now = year+mon;

	for(var i = (now - 5); i <= now; i++){
		var format =  i;
		monthList.push(format);
	}

	const ctx = document.getElementById('myChart').getContext('2d');
	const myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: monthList,
			datasets: [{
				data: monthData,
				borderColor:'rgba(255, 99, 132, 1)',
				borderWidth: 1
			}]
		},

		options: {
		  responsive: true,
		  plugins: {
			legend: {
			  display: false
			}
		  }
		}
	});
</script>
</body>
</html>