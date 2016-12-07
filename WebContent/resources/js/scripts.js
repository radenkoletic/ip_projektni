function getRequestObject() {
	if (window.XMLHttpRequest) {
		return(new XMLHttpRequest());
	} else if (window.ActiveXObject) { 
		return(new ActiveXObject("Microsoft.XMLHTTP"));
	} else {
		return(null); 
	}
}

function handleResponse(request) {
	if (request.readyState == 4 && request.status==200) {
	}
}

function sendRequestActivate(address, id) {
	var request = getRequestObject();
	request.onreadystatechange = function() { 
		handleResponse(request) 
	};
	var selectID = 'select' + id;
	var select = document.getElementById(selectID);
	var selectValue = select.options[select.selectedIndex].text;
	address = address + '&type=' + selectValue;
	request.open("GET", address, true);
	request.send(null);
}

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            document.getElementById('img-prof').src =  e.target.result;
        }

        reader.readAsDataURL(input.files[0]);
    }
}
