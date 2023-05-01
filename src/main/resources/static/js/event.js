/**
 * 회원가입 시 전화번호에 하이픈 사용 못하게 막기
 */

function onlyNumber() {
	
	const reg = /\D/g;
	event.target.value = event.target.value.replace(reg, "");
	
}