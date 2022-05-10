page = document.getElementById("page")

try {   xhr = new ActiveXObject('Msxml2.XMLHTTP');   }
    catch (e) 
    {
        try {   xhr = new ActiveXObject('Microsoft.XMLHTTP'); }
        catch (e2) 
        {
           try {    xhr = new XMLHttpRequest();  }
           catch (e3) {  xhr = false;   }
         }
    }

xhr.responseType = "text"; //will be changed to "json" later

function updatePage(url){
    console.log("click on"+ url)
    xhr.open("GET", url)
    xhr.send()
    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            console.log("Request succeeded")
            page.innerHTML = this.response;
        }
    }
}

updatePage("/frontpage.html")