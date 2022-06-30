
const subscribeForm = document.getElementById("subscribe-form");
const subscribeButton = document.getElementById("subscribe-form-submit");
const subscribeErrorMsgUsername = document.getElementById("subscribe-error-msg-username");
const subscribeErrorMsgPassword = document.getElementById("subscribe-error-msg-password");

subscribeButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = subscribeForm.username.value;
    const password = subscribeForm.password.value;
    //le mots de passe ne doit pas être vide
    if (password != "") {
        console.log(username + " " + password)
        try {
            //callwebservice et vas voir si le username existe deja
            //renvoie false si deja dans la base sinon true et crée le user
            callWebService("/users/user/subscribe/username=" + username.toString() + "&password=" + password.toString(), inscription, 'GET', 1, insciptionFailed)
        } catch (e) {
            console.error(e);
            console.log("error")
        }
    }
    else {
        //mots de passe vide
        console.log("mots de passe incorrecte")
        subscribeErrorMsgPassword.style.opacity = 1;
    }
    //inscrit le user
    function inscription(data){
        //si le username n'existe pas le user est crée
        if (data){

            console.log("inscirption réussite")
            alert("You have successfully subscribed.");
            document.location.href="./login.html";
        }
        //si le username existe message d'erreur "username not available
        else {
            console.log("existe deja")
            subscribeErrorMsgUsername.style.opacity = 1;
        }
    }
    //fonction callwebservice fail
    function insciptionFailed(){
        console.log("inscription failed")
    }
})