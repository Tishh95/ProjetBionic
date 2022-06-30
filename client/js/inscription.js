
const subscribeForm = document.getElementById("subscribe-form");
const subscribeButton = document.getElementById("subscribe-form-submit");
const subscribeErrorMsgUsername = document.getElementById("subscribe-error-msg-username");
const subscribeErrorMsgPassword = document.getElementById("subscribe-error-msg-password");

subscribeButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = subscribeForm.username.value;
    const password = subscribeForm.password.value;
    if (password != "") {
        console.log(username + " " + password)
        try {
            //callwebservice et vas voir si une paire username/password existe
            //si il en existe une ça se connecte sinon message d'erreur
            callWebService("/users/user/subscribe/username=" + username.toString() + "&password=" + password.toString(), inscription, 'GET', 1, insciptionFailed)
        } catch (e) {
            console.error(e);
            console.log("error")
        }
    }
    else {
        console.log("mots de passe incorrecte")
        subscribeErrorMsgPassword.style.opacity = 1;
    }

    function inscription(data){
        if (data){

            console.log("inscirption réussite")
            alert("You have successfully subscribed.");
            document.location.href="./login.html";
        }
        else {
            console.log("existe deja")
            subscribeErrorMsgUsername.style.opacity = 1;
        }
    }

    function insciptionFailed(){
        console.log("inscription failed")
    }
})