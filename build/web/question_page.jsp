<%-- 
    Document   : question_page
    Created on : 31 Oct 2023, 8:43:29 PM
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
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
            
            List<Question> questions = (List<Question>)session.getAttribute("questionsAndAns");
            
            Integer ques_counter = (Integer)session.getAttribute("ques_counter");
            String question = questions.get(ques_counter).getQuestion();
            String option1 = questions.get(ques_counter).getOption1();
            String option2 = questions.get(ques_counter).getOption2();
            String option3 = questions.get(ques_counter).getOption3();
            String option4 = questions.get(ques_counter).getOption4();
            
            
            
            
           ques_counter++;
            
        %>
       <div class="app">
            <h1>Question <%=ques_counter%></h1>
            
            <div class="quiz">
                
                <h2 id="question"><%=question%></h2>
                
                <div id="answer-button"></div>  
                
                <form action="ProcessAnsServlet" method="POST">

                        <table>

                            <tr>
                                <td><button class="btn">A. <%=option1%></button></td>
                            </tr>
                            <tr>
                                <td><button class="btn">B.<%=option2%></button></td>
                            </tr>
                            <tr>
                                <td><button class="btn">C. <%=option3%></button></td>
                            </tr>
                            <tr>
                                <td><button class="btn">D. <%=option4%></button></td>
                            </tr>
                            <tr>

                                <td><h2 id="question">Enter Answer: </h2></td>
                                <td><input class="ans_input" type="text" name="user_answer"></td>
                                
                            </tr>

                        </table>
                        <td><button class="subbtn">submit</button></td>


                    </form>
                    
 
            </div>
            
            
        </div>
    </body>
</html>
