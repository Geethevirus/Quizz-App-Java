<%-- 
    Document   : question_page
    Created on : 31 Oct 2023, 8:43:29 PM
    Author     : ACER
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            List<String> questions = (List<String>)session.getAttribute("questions");
            Integer ques_counter = (Integer)session.getAttribute("ques_counter");
            String question = questions.get(ques_counter);
            ques_counter++;
           
            
        %>
        <h1>Question <%=ques_counter%></h1>
        <p><%=question%></p>
        <br>
        
        <form action="ProcessAnsServlet" method="POST">
            <table>
                <tr>
                    <td><input type="text" name="usrAns"/></td>
                    <td><input type="submit" value="SUBMIT"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
