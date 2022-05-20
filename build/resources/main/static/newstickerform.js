color = document.getElementById(color)
    comment = document.getElementById(comment)
    today = new Date();
    try {   xhr = new ActiveXObject('Msxml2.XMLHTTP');   }
    catch (e) {
        try {   xhr = new ActiveXObject('Microsoft.XMLHTTP'); }
        catch (e2) {
            try {    xhr = new XMLHttpRequest();  }
            catch (e3) {  xhr = false;   }
        }
    }
    xhr.responseType = "text"; //will be changed to "json" later

    function newSticker(){
        console.log("sending request")
        xhr.open("GET", "/newsticker?color="+color.value+"&"+comment.value+"&"+today.getDate())
        xhr.send()
    }