function check(content){
    const settings = {
        "async": true,
        "crossDomain": true,
        "url": "https://bionic-reading1.p.rapidapi.com/convert",
        "method": "POST",
        "headers": {
            "content-type": "application/x-www-form-urlencoded",
            "X-RapidAPI-Key": "3e2c600477msh7f8cc1d40ebce55p176be2jsn52a8142ea89a",
            "X-RapidAPI-Host": "bionic-reading1.p.rapidapi.com"
        },
        "data": {
            "content": content ,
            "response_type": "html",
            "request_type": "html",
            "fixation": "1",
            "saccade": "10"
        }
    };

    $.ajax(settings).done(function (response)  {
        text.innerHTML = response;
    });}

function fill() {
    console.log('appel à la fonction fill() de changeNote')
    let note = getProp('note',true)
    userid = getProp('userid',false)
    console.log(note.title)
    const container = document.getElementById('title');

    const text = document.createTextNode(note.title);
    container.appendChild(text);
    check(note.note)
}