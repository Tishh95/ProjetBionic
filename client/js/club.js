let club
let addPerson = ' '
let addNote = ' '
let person = []
let list
function fill() {
    console.log('appel à la fonction fill()...')
    club = getProp('club',true)
    console.log(club.id)
    let userid = getProp('userid',false)
    console.log(userid)
    console.log(club)
    callWebService("/clubs/userclub/",personOK, 'GET',1)
    callWebService("/notes/list", noteOk, 'GET',1)

}

function personOK(data) {
    gperon = data
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
        '<td>'+person[k].id+'</td>' +
            '</div></a>'
    }
    document.getElementById('userList').innerHTML += addPerson;
}

function noteOk(data) {
    gnotes =data
    let notes = []
    for(i in data) {
        if(data[i].club_id == club.id) {
            notes.push(data[i])
        }
    }
    for(k in notes){
        addNote += '<div class="divNotes"> ' +
            '</br>' +
            '<td><a  onclick="displayOneNote('+k+')">'+notes[k].title+'</td>' + '</br>' +
            '<td>'+notes[k].note+'</td>' +
            '</div></a>'
    }
    document.getElementById('notesList').innerHTML += addNote;
}


function displayOneNote(id) {

    let note = gnotes[id];
    putProp('note',note,true)
    post('watchNote.html')
}
