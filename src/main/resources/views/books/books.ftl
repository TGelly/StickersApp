<#ftl encoding="utf-8">

    <body xmlns="http://www.w3.org/1999/html">

        <ul>
            <#list books as book>
                <li>
                ${book.childName!} 
                <input type="button" value="book" onclick="updatePage('/stickers?bookID=${book.bookId}')"> <br>
                </li>
                
            </#list>
        </ul>

    </body>

</html>
