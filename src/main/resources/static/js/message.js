/**
 * 메세지 전송창
 */


function new_window(id) {
	window.open(
		"/user/auth/sendMsg/"+id,
		"insert",
		"width=500, height=300, top=250, left=650"
	);
}