<%-- 
    Document   : summary
    Created on : 23 Nov 2023, 3:15:05 AM
    Author     : ACER
--%>

<%@page import="za.ac.tut.model.Question"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="stylesum.css">
    </head>
    <body>
       
        <%
            
            List<Question> listAnA = (List<Question>)session.getAttribute("questionsAndAns");
            String stud_name = (String)session.getAttribute("stud_name");
            List<String> outcomes = (List<String>)session.getAttribute("outcome");
            List<String> stud_answrs = (List<String>)session.getAttribute("stud_answrs");
            Integer num_correct = (Integer)session.getAttribute("num_correct");
            String exam_outcome = (String)request.getAttribute("exam_outcome");
            Double percentage = (Double)request.getAttribute("perc");
            Integer counter =1;
            

        %>
        
        <div class="container">
            <h1>Summary </h1>
            <div class="sum_content">
                <h2 >STUDENT NAME: <%=stud_name%></h2>
                <h2 class="">TEST SCORE <%=num_correct%> / 5 </h2>
                <h2 class="">EXAM OUTCOME: <%=percentage%>% </h2>
                <h2 class="hh">EXAM STATUS: <%=exam_outcome%></h2>
                
                <table>
                    <% for(int i= 0;  i < 5 ; i++) {
                        
                        String outcome = outcomes.get(i);
                        String question = listAnA.get(i).getQuestion();
                        String correctAns = listAnA.get(i).getCorrectAnswer();
                        String userAns = stud_answrs.get(i);
                        

                    %>
                    <tr>
                        
                        <td><h1></h1></td>
                        <td></td>
                                            
                    </tr>
                  
                    <tr>
                        
                        <td>Question <%=counter%>: </td>
                        <td><%=question%></td>
                        
                    </tr>
                    <tr>
                        
                        <td>Correct Answer: </td>
                        <td><%=correctAns%></td>
                                               
                    </tr>

                    <tr>
                        
                        <td>Student Answer: </td>
                        <td><%=userAns%></td>
                                            
                    </tr>
                    <tr>
                        
                        <td>Question Result : </td>
                        <td><%=outcome%></td>
                                            
                    </tr>
                    
                    
                  
                    <% counter++;}%>
                    
                </table>

            </div>

        </div>
    </body>
</html>
