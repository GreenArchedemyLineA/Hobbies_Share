/**
 * 메세지 전송창
 */


function sendMsg_window(id) {
	window.open(
		"/user/auth/sendMsg/"+id,
		"insert",
		"resizable=no,width=500, height=300, top=250, left=650"
	);
}

function messageBox_window(){
	window.open(
		"/user/auth/select-A-msg",
		"select",
		"width=870, height=600, top=200, left=570"
	);
}

<<<<<<< HEAD
=======
function sendLogin(){
	alert("로그인 후 이용해주세요!")
	location.href = "/user/log-in";
}
>>>>>>> bc090301b21cd3f5d8842dc99cb4e720d6ca3f73
