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
        <link rel="stylesheet" href="nampage.css">
    </head>
    <body>
     
        <div class="container">
            <h1>Please Enter the following.</h1>
            <div class="welmsg">


                <form action="StartServlet">

                    <table>
                        <tr>
                            <td><h3>Enter your name:</h3></td>
                            <td><input class="nameinp" type="text" name="user_name"/></td>
                        </tr>

                    </table>
                    <td><button class="subbtn">submit</button></td>
                </form>

            </div>

        </div>
        
    </body>
</html>
