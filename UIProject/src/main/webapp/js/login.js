/**
 * 
 */
window.onload = function() {
	const loginForm = document.getElementById("login-form");
	const loginButton = document.getElementById("login-form-submit");
	const loginErrorMsg = document.getElementById("login-error-msg");

	loginButton.addEventListener("click", (event) => {
		event.preventDefault();
		const username = loginForm.username.value;
		const password = loginForm.password.value;

		if (username === "user" && password === "1234") {
			alert("로그인 완료!");
			location.href = "../index.html";
		} else {
			loginErrorMsg.style.opacity = 1;
		}
	});
}
