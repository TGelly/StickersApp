page = document.getElementById("page")
booksButton = document.getElementById("books")
usersButton = document.getElementById("users")
booksButton.onclick = books
usersButton.onclick = users

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
xhr.responseType = "json";

function books(){
    console.log("Displaying books")
    xhr.open("GET", "/books")
    xhr.send()
    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            console.log(this.response);
            updatePage(this.response)
        }
    }
}
function users(){
    console.log("Displaying users")
    page.innerHTML = "Users display"
}

function updatePage(content){
    page.innerHTML = content;
}