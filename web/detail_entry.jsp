<%-- 
    Document   : detail_entry
    Created on : 31 Oct 2023, 8:28:28 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please Enter the following.</h1>
        <form action="StartServlet">
            <table>
                <tr>
                    <td>Enter your name:</td>
                    <td><input type="text" name="stud_name"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="SUBMIT"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
