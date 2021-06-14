<%-- 
    Document   : editNote
    Created on : Jun 13, 2021, 6:12:43 PM
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
        <br>
        <h2>Edit Note</h2>
        <br>
        <form method="post" action="note">
        <label>Title:</label>
        <input type="text" name="title" value="${note.title}">
        <br>
        <label>Contents:</label>
        <textarea type="text" name="contents" value="${inContents}">${note.contents}</textarea>
        <br>
        <input type="submit" value="Save">
        </form>
        
    </body>
    <br>
</html>
