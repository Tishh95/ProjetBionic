const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;

    $.getScript("./js/custom.js",function (){
        callWebService();
    });

    callWebService("/user/login_check/username=" + username + "&password=" + password, null, log, null, 'GET', 1)

    function log(data,idx){
        console.log("test");
    }

    if (username === "user" && password === "web_dev") {
        alert("You have successfully logged in.");
        location.reload();
    } else {
        loginErrorMsg.style.opacity = 1;
    }
})

const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");


loginButton.addEventListener("click", (e) => {


    $.getScript("./js/custom.js",function (){
        callWebService();
    });
    const username = loginForm.username.value;
    const password = loginForm.password.value;

    console.log('chercher si aucun log existe()...')
        callWebService("/user/login_check/username=" + username + "&password=" + password, null, log, null, 'GET', 1)


    })
function log(data,idx){
    console.log("test");
}

function loginCheck(data, idx){
    const id = data;
    console.log('loginCheck')
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;
    let user_id = 3
    console.log('appel à la fonction fill()...')


    if (username === "admin" && password=== "admin") {
        alert("You have successfully logged in.");
        location.reload();
    } else {
        loginErrorMsg.style.opacity = 1;
    }

}