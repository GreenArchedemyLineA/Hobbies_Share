/**
 * 이메일, 닉네임 중복체크
 */

const emailInputTag = document.getElementById("email");
const emailValidationButton = document.getElementById("emailChecker");



emailValidationButton.addEventListener("click", () => {
	console.log(emailInputTag.value);
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
})


const nicknameInputTag = document.getElementById("nickname");
const nicknameValidationButton = document.getElementById("nicknameChecker");

nicknameValidationButton.addEventListener("click", () => {
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

})