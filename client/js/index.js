function fill(){
    let user_id = 3
    console.log('appel à la fonction fill()...')
    callWebService("/users/user/note/" + user_id  ,notesOk, 'GET',1)
}
function notesOk(data, idx){
    gNotes= data.notes
    console.log('Retour Web Service cities')
    let addNotes = ' ', bk = ''
    for (k in data.notes) {
        console.log(data.notes)
        addNotes += '<div class="divNotes"> ' +
            '<td ><a  onclick="displayOneNote('+k+')">'+data.notes[k].title+'</td>' +
            '</br>' +
            '<td>'+data.notes[k].note+'</td>' +
            '</div></a>' +
            '<button onclick="drop('+data.notes[k].id+')"> delete</button>';
    }
    if(data.clubs.length > 0) {
        clubOk(data.clubs)
    }
    document.getElementById('tabNotes').innerHTML += addNotes;
}

function clubOk(data) {
    let addClub = ' '
    for ( key in data ){
        gClubs= data
        let club = data[key] ;
        console.log(club)
        addClub += '<div class="divNotes"> ' +
            '<td >'+club.name+'</td>' +
            '</br>' +
            '<td><a  onclick="displayOneClub('+key+')">'+club.creationDate+'</a></td>' +
            '</div>' ;
    }
    document.getElementById('tabClubs').innerHTML += addClub;
}

function displayOneClub(id) {
    console.log('display')
    let club = gClubs[key];
    putProp('club',club,true)
    post('club.html')
}
function displayOneNote(id) {
    console.log('display')
    let note = gNotes[k];
    putProp('note',note,true)
    post('watchNote.html')
}
function drop(id) {
    callWebService("/notes/note/drop/"+ id  ,null,deleteOk, null, 'GET',1)
}
function deleteOk() {
    fill()
}
