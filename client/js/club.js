let club
let addPerson = ' '
let addNote = ' '
function fill() {
    console.log('appel à la fonction fill()...')
    club = getProp('club',true)
    console.log(club.id)
    let userid = getProp('userid',false)
    console.log(userid)
    console.log(club)
    callWebService("/clubs/userclub/",clubOk, 'GET',1)
    callWebService("/notes/list", noteOk, 'GET',1)
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

function noteOk(data) {
    let notes = []
    for(i in data) {
        if(data[i].club_id == club.id) {
            notes.push(data[i])
        }
    }
    for(k in notes){
        addPerson += '<div class="divNotes"> ' +
            '</br>' +
            '<td>'+notes[k].title+'</td>' +
            '</div></a>'
    }
    document.getElementById('notesList').innerHTML += addNote;
}