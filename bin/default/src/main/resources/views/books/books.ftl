<#ftl encoding="utf-8">

    <body xmlns="http://www.w3.org/1999/html">

        <ul>
            <#list books as book>
                <li>${book.childName!} </li>
            </#list>
        </ul>

        <#list books as book>
            <a href="cerise.freeboxos.fr:8081/stickers?bookID=${book.bookID!}">book ${book.bookID}</a>
        </#list>

    </body>

</html>
