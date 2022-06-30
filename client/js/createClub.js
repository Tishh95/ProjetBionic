let userid
function fill() {
    console.log('appel à la fonction fill() de createClub')
    userid = getProp('userid',false)
    console.log(userid)
}


function create() {

    const title = document.querySelector('input').value;
    console.log(title)
    console.log(userid)
    callWebService("/clubs/create/"+title+"/"+userid,createOk,'GET',1)
}

function createOk(data) {
    console.log(data)
    post('index.html')
}