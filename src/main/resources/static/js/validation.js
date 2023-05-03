/**
 * 이메일, 닉네임 중복체크
 */

const emailInputTag = document.getElementById("email");
const emailValidationButton = document.getElementById("emailChecker");

function correctEmail(value) {
	let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
	if (!regex.test(value)) {
		alert("올바르지 못한 이메일 형식입니다.")
		return false;
	}
	return true;
}
function correctNickname(value) {
	let regex = new RegExp('[가-힣|a-z|A-Z|0-9|]');
	if (!regex.test(value)) {
		alert("올바르지 못한 형식입니다.")
		return false;
	}
	return true;
}



emailValidationButton.addEventListener("click", () => {
	console.log(emailInputTag.value);
	if (correctEmail(emailInputTag.value)) {
		fetch("/auth/email-check", {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify({
				"email": emailInputTag.value
			})
		}).then(async (response) => {
			let responseJson = await response.json();
			if (responseJson.successCode) {
				alert("사용가능한 이메일입니다.")
			} else {
				alert("이미 사용중인 이메일입니다.")
			}
		})
	}

})


const nicknameInputTag = document.getElementById("nickname");
const nicknameValidationButton = document.getElementById("nicknameChecker");

nicknameValidationButton.addEventListener("click", () => {
	if (correctNickname(nicknameInputTag.value)) {
		fetch("/auth/nickname-check", {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify({
				"nickname": nicknameInputTag.value
			})
		}).then(async (response) => {
			let responseJson = await response.json();
			if (responseJson.successCode) {
				alert("사용가능한 닉네임입니다.")
			} else {
				alert("이미 사용중인 닉네임입니다.")
			}
		})
	}
})