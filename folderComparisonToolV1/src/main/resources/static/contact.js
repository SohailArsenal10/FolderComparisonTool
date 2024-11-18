const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const firstForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");

signInBtn.addEventListener("click", () => {
	container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
	container.classList.add("right-panel-active");
});

firstForm.addEventListener("submit", (e) => e.preventDefault());
secondForm.addEventListener("submit", (e) => e.preventDefault());


$.fn.backButton = function() {
  if (document.referrer !== "") {
    $(this).show();
    $(this).on('click', function(e) {
      e.preventDefault();
      window.location.href = document.referrer;
    });
  }
}

$('.back-button').backButton();