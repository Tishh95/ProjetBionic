function f1() {
    //function to make the text bold using DOM method
    document.getElementById("textarea1").style.fontWeight = "bold";
}

function f2() {
    //function to make the text italic using DOM method
    document.getElementById("textarea1").style.fontStyle = "italic";
}

function f3() {
    //function to make the text alignment left using DOM method
    document.getElementById("textarea1").style.textAlign = "left";
}

function f4() {
    //function to make the text alignment center using DOM method
    document.getElementById("textarea1").style.textAlign = "center";
}

function f5() {
    //function to make the text alignment right using DOM method
    document.getElementById("textarea1").style.textAlign = "right";
}

function f6() {
    //function to make the text in Uppercase using DOM method
    document.getElementById("textarea1").style.textTransform = "uppercase";
}

function f7() {
    //function to make the text in Lowercase using DOM method
    document.getElementById("textarea1").style.textTransform = "lowercase";
}

function f8() {
    //function to make the text capitalize using DOM method
    document.getElementById("textarea1").style.textTransform = "capitalize";
}

function f9() {
    //function to make the text back to normal by removing all the methods applied
    //using DOM method
    document.getElementById("textarea1").style.fontWeight = "normal";
    document.getElementById("textarea1").style.textAlign = "left";
    document.getElementById("textarea1").style.fontStyle = "normal";
    document.getElementById("textarea1").style.textTransform = "capitalize";
    document.getElementById("textarea1").value = " ";
}
function create() {
    let note = [
    {
        "title": document.querySelector('input').value,
        "content": document.querySelector('textarea').value,
    }
    ]
    const title = document.querySelector('input').value;
    const content = document.querySelector('textarea').value;
    console.log(title)
    console.log(content)
    callWebService("/notes/note/create/" +title+"/"+content,null,r, null, 'GET',1)
}
function fill() {
    console.log('appel à la fonction fill()...')
    let note = getProp('note',true)

    document.querySelector('input').value = note.title;
    document.querySelector('textarea').value = note.note
    console.log(note)
}

function r(data){
    console.log(data)
}