let user_id
function fill(){

    user_id = getProp('idUser',true)
    console.log('appel à la fonction fill()...')
    console.log(user_id)
    callWebService("/users/user/" + user_id  ,notesOk, 'GET',1)
}
function notesOk(data, idx){
    gNotes= data.notes
    console.log('Retour Web Service users')
    let addNotes = ' ', bk = ''
    for (k in data.notes) {
        addNotes +=
            '<div class="container">'+
            '<div class="row hidden-md-up">'+
            '<div class="col-md-4">'+
            '<div class="card ">' +
            '<div class="card-block">' +
            '<div class="divNotes"><a  onclick="displayOneNote('+k+')"> ' +
            '<h4  class="card-title"> '+data.notes[k].title+'</h4>' +
            '<div class="card-text p-y-1">'+data.notes[k].note+'</div>' +
            '</div></a>' +
            '<button onclick="drop('+data.notes[k].id+')"> delete</button>' +
            '</div></div></div></div></div>'
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
        addClub +=  '<div class="container">'+
            '<div class="row hidden-md-up">'+
            '<div class="col-md-10">'+
            '<div class="card ">' +
            '<div class="card-block">' +
            '<div style="text-align: center" class="divNotes"><a onclick="displayOneClub('+key+')"> ' +
            '<h4  class="card-title"> '+club.name+'</h4>' +
            '<div class="card-text p-y-1">'+club.creationDate+'</div>' +
            '</div></a>' +
            '</div></div></div></div></div>';


    }
    document.getElementById('tabClubs').innerHTML += addClub;
}
function displayOneClub(id) {
    console.log('display')
    let club = gClubs[id];
    putProp('club',club,true)
    console.log(club)
    putProp('userid',user_id,false)
    post('club.html')

}
function displayOneNote(id) {
    console.log('display')
    let note = gNotes[id];
    putProp('note',note,true)
    post('watchNote.html')
}
function drop(id) {
    callWebService("/notes/note/drop/"+ id  ,deleteOk, 'GET',1)
}
function deleteOk() {
    clearBox()
    fill()
}
function opencreate() {
    console.log('display')
    let user =user_id;
    putProp('user',user,true)
    post('create.html')
}
function clearBox() {
    var div = document.getElementById(tabNotes);

    while(div.firstChild) {
        div.removeChild(div.firstChild);
    }
}
function opencreateClub() {
    console.log('display')
    let user =user_id;
    putProp('user',user,false)
    post('createClub.html')
}

function deco() {
    user_id = null;
    console.log(user_id)
    removeProp('idUser')
    localStorage.clear();
    window.location.reload();
    post('login.html')

}