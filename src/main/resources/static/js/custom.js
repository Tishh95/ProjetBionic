// Root URL of Backend Application Server
let webURL = "https://bionic-reader-demo.herokuapp.com/bionic" ;
// let globalCities = '' ;
// let globalCountries = '' ;
// let globalUsers = '' ;
/**
 * localStorage MANAGMENT
 * @param key
 * @param value
 * @param jsonType
 * @returns : Nothing or Alert if localStorage not supported
 */
 function putProp(key, value,jsonType){
	if (typeof(Storage) !== "undefined") {
		if ( jsonType ){
			localStorage.setItem(key, JSON.stringify(value));
		}else{
			localStorage.setItem(key, value);
		}		
	} else {
		alert('localStogage NOT SUPPORTED by this Browser...') ;
	}	    
}

/**
 * Get localStored property 
 * if jsonType is true presume that property is stored with JSON.strinify and JSON.parsed before returned
 * @param key
 * @param jsonType
 * @returns : value of property
 */
function getProp(key,jsonType){
	var obj = null ;
	if (typeof(Storage) !== "undefined") {
		var obj = localStorage.getItem(key) ;
		if ( jsonType ){
			obj = JSON.parse(obj);
		}	
	} else {
		alert('localStogage NOT SUPPORTED by this Browser...') ;
	}
	return obj ;
}
/**
 * Remove localStogage property by key
 * @param key
 * @returns : true
 */
function removeProp(key)
{
	if (typeof(Storage) !== "undefined") {
		localStorage.removeItem(key);
	} else {
		alert('localStogage NOT SUPPORTED by this Browser...') ;
	}
}

function throwError(msg){
	let m = document.getElementById('sysMsg') ;
	m.innerHTML = msg;
}

function callFetch(wsURL, _data, method, entity) {
    console.log('Enter callFetch :'+wsURL)
	// Define Headers 
	// Get Token
	token = 'Bearer '+getProp('XToken') ;
	console.log('Token :'+token )

	const headers  = new Headers();
	headers.append('Accept', '*/*');
	headers.append("Content-type", "application/json; charset=UTF-8");
	headers.append("Authorization", token);

	// Options

	const options = {
			method: 'GET',
			headers: headers,
			withCredentials: true,
			cors : 'no-cors'
	};

	if ( _data )
		options.body = JSON.stringify(_data)
	else
		options.body = null

	let  webServiceURL = webURL + wsURL ;

	console.log('url :'+webServiceURL+" opt : "+options.method)

	fetch(webServiceURL, options)
		.then(response => response.ok ? response.json() : null, 'Fetch error :'+response.status)
		.then((result,msg)  => result ? setEntity(entity, result) : throwError(msg))
		.catch(err => throwError('Fetch Error ...'));
	alert('Stop')
	console.log('End callFetch ') ;
}

function setEntity(entity, result){
	console.log('Set entity :'+entity)
	entity = result;
}

function getEntity(entity){
	console.log('Get entity :'+entity)
	return entity;
}

async function authenticate(wsURL, _data) {
    console.log('Enter authenticate ')
	// Define parameters 
	const headers  = new Headers();
	headers.append('Accept', '*/*');
	headers.append("Content-type", "application/json; charset=UTF-8");

	const options = {
			method: 'POST',
			headers: headers,
			body: JSON.stringify(_data)
	};
	let  webServiceURL = webURL + wsURL ;

	console.log('url :'+webServiceURL)

	fetch(webServiceURL, options)
		.then(response => response.ok ? response.json() : console.log('Fetch error :'+response.status))
		.then(result => result ? recordToken(result) : throwError('Authentication Error ...'))
		.catch(err => throwError('Authentication Error ...'));
	
	console.log('End authenticate ') ;
}

function recordToken(tk){
	if ( tk ){
		console.log("Recorded Token : "+tk.token);
		putProp('XToken',tk.token)
		post('index.html')
	}else
		tk = 'Authentication Error'
	
	return tk;
}

/**
 * Method to forward an HTML page from javascript
 * @param path : Path of HTML page
 * @param params : parameters if any
 * @param method : get|post (post default)
 * @returns : false
 */
 function post(path, params, method) {
    method = method || "post"; // Set method to post by default if not specified.

    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    // form.setAttribute("method", method);
    form.setAttribute("action", path);

    for(var key in params) {
        if(params.hasOwnProperty(key)) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
         }
    }

    document.body.appendChild(form);
    form.submit();
}

function clearError(){
	document.getElementById('sysMsg').innerHTML = ''
}

function OnErrorStd(jqXHR, status, error)
{
	if ( jqXHR.responseText || status || error ){
		   document.getElementById('sysMsg').innerHTML += 'Error >>> ' + jqXHR.responseText + " - " + jqXHR.status + " - " + error ;
	}
}

function callWebService(wsURL,successMethod,httpMethod,index, errorMethod)
{

	if ( httpMethod === null ){
		httpMethod = 'POST';
	}

	if ( errorMethod == null ){
		errorMethod = OnErrorStd;
	}
	
	var webServiceURL = webURL + wsURL ;
	var token = 'Bearer ' + getProp('XToken') ;
	
    $.ajax({
		// xhrFields: {
    	//     withCredentials: true
    	// },
    	cache : false,
    	beforeSend: function(request) {
    	    request.setRequestHeader("Authorization", token);
			request.setRequestHeader("Access-Control-Allow-Credentials", true);
    	},
        url: webServiceURL,
        type: httpMethod ,
        // dataType: 'json',
        // contentType: "application/json; charset=utf-8",
        process : false ,
        success:  function(data) {
        	successMethod(data,index);
        }, 
        error:  function(error,status,err) {
			errorMethod(error,status,err);
        }, 
    });
    
}
