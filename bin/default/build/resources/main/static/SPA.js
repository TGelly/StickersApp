page = document.getElementById("page")
booksButton = document.getElementById("books")
usersButton = document.getElementById("users")
booksButton.onclick = books
usersButton.onclick = users
function books(){
    console.log("Displaying books")
    xhr = new XMLHttpRequest 
    page.innerHTML = "Books display"
}
function users(){
    console.log("Displaying users")
    page.innerHTML = "Users display"
}