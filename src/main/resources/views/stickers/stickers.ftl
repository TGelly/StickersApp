<#ftl encoding="utf-8">

    <body xmlns="http://www.w3.org/1999/html">

        <ul>
            <#list stickers as sticker>
                <li>${color!} - ${comment!}</li>
            </#list>
        </ul>

    </body>

</html>
