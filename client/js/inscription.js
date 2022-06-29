
const subscribeForm = document.getElementById("subscribe-form");
const subscribeButton = document.getElementById("subscribe-form-submit");
const subscribeErrorMsg = document.getElementById("subscribe-error-msg");

subscribeButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = subscribeForm.username.value;
    const password = subscribeForm.password.value;

    if (username === "user" && password === "user") {
        alert("You have successfully logged in.");
        location.reload();
    } else {
        subscribeErrorMsg.style.opacity = 1;
    }
})