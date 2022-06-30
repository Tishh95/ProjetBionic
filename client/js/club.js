function fill() {
    console.log('appel à la fonction fill()...')
    let club = getProp('club',true)
    let userid = getProp('userid',false)
    console.log(userid)

    callWebService("/clubs/userclub/",clubOk, 'GET',1)
}

function clubOk(data) {
    let person = []
    for( k in data) {
        if(data[k].clubs.length > 0){
            for(j in data[k].clubs){
                person.push(data[k].name)
            }
        } else {
        }

    }

    document.getElementById('userList').innerHTML += person;

}