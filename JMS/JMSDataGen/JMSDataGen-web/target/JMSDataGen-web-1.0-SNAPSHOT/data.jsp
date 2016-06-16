<%-- 
    Document   : data
    Created on : Dec 14, 2013, 7:20:16 PM
    Author     : Family
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert Name , Amount and Type Below</h1>
        <form action="dis">
        Name:<input type="text" name="name"/>
        <br/>
         <br/>
        Amount: <input type="text" name="amount"/>
        <br/>
        <br/>
        Select Type:<select name="destinationType">
            <option value="queue">Queue</option>
            <option value="topic">Topic</option>
        </select>
        <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
