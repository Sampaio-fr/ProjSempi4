
// IMPORTANT: notice the next request is scheduled only after the
//            previous request is fully processed either successfully
//	      or not.

function getBoardTitleHTML() {
	var request = new XMLHttpRequest();
        var vBoard=document.getElementById("board");
        
        request.onload = function() {
            vBoard.innerHTML = this.responseText;
            vBoard.style.color="black";
            setTimeout(getBoardTitleHTML, 2000);
            };
            
        request.ontimeout = function() {
            vBoard.innerHTML = "Server timeout, still trying ...";
            vBoard.style.color="red";
            setTimeout(getBoardTitleHTML, 100);
        };
        
        request.onerror = function() { 
            vBoard.innerHTML = "No server reply, still trying ...";
            vBoard.style.color="red";
            setTimeout(getBoardTitleHTML, 5000);
        };
        
  	request.open("GET", "/board", true);
	request.timeout = 5000;
  	request.send();
	}

function getMatrix() {
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("matrix");

    request.onload = function() {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color="black";
        setTimeout(getMatrix, 5000);
    };

    request.ontimeout = function() {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color="red";
        setTimeout(getMatrix, 1000);
    };

    request.onerror = function() {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color="red";
        setTimeout(getMatrix, 10000);
    };

    request.open("GET", "/matrix", true);
    request.timeout = 10000;
    request.send();
}
	

