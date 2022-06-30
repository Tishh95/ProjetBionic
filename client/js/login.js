const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;
    console.log(username + " " +password)

    $.getScript("./js/custom.js",function (){
        //callWebService();
    });
    try {
        callWebService("/users/user/login_check/username=" + username.toString() + "&password=" + password.toString(), null, connectionSuccess, null, 'GET', 1, connectionFailed)
    }catch (e) {
        console.error(e);
        console.log("error")
    }
        // callWebService("/users/user/login_check/username=admin&password=admin", null, log, null, 'GET', 1)
    //callWebService("/users/user/note/3"  ,null,log, null, 'GET',1)

    function connectionFailed(){
        console.log("pas connection")
        loginErrorMsg.style.opacity = 1;
    }

    function connectionSuccess(data){
        //conexion base de donnée et transmettre id
        console.log("logged successfully")
        alert("You have successfully logged in.");
        location.reload();
    }
})


