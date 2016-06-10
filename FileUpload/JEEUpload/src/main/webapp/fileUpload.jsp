<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="upload" enctype="multipart/form-data" >
            <input type="text" name="PlainName" value="Rahul"/>
            File:
            <input type="file" name="file" id="file" /> <br/>
            <!--Destination:
            <input type="text" value="/tmp" name="destination"/>-->
            </br>
            <input type="submit" value="Upload" name="upload" id="upload" />
        </form>
    </body>
</html>
