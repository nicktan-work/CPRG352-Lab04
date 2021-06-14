<%-- 
    Document   : viewNote
    Created on : Jun 13, 2021, 6:13:06 PM
    Author     : 846582
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab04</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>

        <h2>View Note</h2>

        <form method="post" action="note">
            <h4>Title: </h4> 
            <p> ${note.title}</p>
            <h4>Contents: </h4>
            <p>${note.contents}</p>
        </form>

        <br>
        <a href="note?edit">Edit</a> 

    </body>

</html>