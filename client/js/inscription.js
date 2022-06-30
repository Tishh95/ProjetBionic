
const subscribeForm = document.getElementById("subscribe-form");
const subscribeButton = document.getElementById("subscribe-form-submit");
const subscribeErrorMsg = document.getElementById("subscribe-error-msg");

subscribeButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = subscribeForm.username.value;
    const password = subscribeForm.password.value;

    try {
        //callwebservice et vas voir si une paire username/password existe
        //si il en existe une ça se connecte sinon message d'erreur
        callWebService("/users/user/subscribe/username=" + username.toString() + "&password=" + password.toString(), inscription, 'GET', 1)
    }catch (e) {
        console.error(e);
        console.log("error")
    }

    function inscription(data){
        if (data!=0){
            console.log("inscirption réussite")
            alert("You have successfully subscribed.");
            document.location.href="./index.html";
        }
        else {
            console.log("pas connection")
            subscribeErrorMsg.style.opacity = 1;
        }
    }
})