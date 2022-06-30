const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    //récupère username et password dans les champs de la page
    const username = loginForm.username.value;
    const password = loginForm.password.value;
    console.log(username + " " +password)
    try {
        //callwebservice et vas voir si une paire username/password existe
        //si il en existe une ça se connecte sinon message d'erreur
        callWebService("/users/user/login_check/username=" + username.toString() + "&password=" + password.toString(), connectionSuccess, 'GET', 1, connectionFailed)
    }catch (e) {
        console.error(e);
        console.log("error")
    }
    function connectionFailed(){
        //aucune paire username/password existant
        console.log("pas connection")
        loginErrorMsg.style.opacity = 1;
    }

    function connectionSuccess(data){
        //connexion passage a la page index en envoyant l'id
        console.log("logged successfully")
        alert("You have successfully logged in.");
        putProp('idUser',data,false)
        document.location.href="./index.html";
    }
})


