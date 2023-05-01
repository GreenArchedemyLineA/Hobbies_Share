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