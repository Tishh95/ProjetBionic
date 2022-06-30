let club
let addPerson = ' '
function fill() {
    console.log('appel à la fonction fill()...')
    club = getProp('club',true)
    console.log(club.id)
    let userid = getProp('userid',false)
    console.log(userid)
    console.log(club)
    callWebService("/clubs/userclub/",clubOk, 'GET',1)
}

function clubOk(data) {
    let person = []
    for( k in data) {
        if(data[k].clubs.length > 0){
            for(j in data[k].clubs){

                if(data[k].clubs[j].id == club.id) {
                    person.push(data[k])
                }
            }
        } else {
        }

    }
    for(k in person){
        addPerson += '<div class="divNotes"> ' +
            '</br>' +
            '<td>'+person[k].name+'</td>' +
            '</div></a>'
    }
    document.getElementById('userList').innerHTML += addPerson;

}