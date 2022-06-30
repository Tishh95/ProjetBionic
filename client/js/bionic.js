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
        "content": "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
        "response_type": "html",
        "request_type": "html",
        "fixation": "1",
        "saccade": "10"
    }
};

$.ajax(settings).done(function (response)  {
    console.log(response);
});


