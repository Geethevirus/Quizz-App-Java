/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.Question;

/**
 *
 * @author ACER
 */
public class ProcessAnsServlet extends HttpServlet {

  
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        String urs_answer = request.getParameter("user_answer");
        int ques_counter = (Integer)session.getAttribute("ques_counter"); 
        String result = ""; 
        List<Question> listQ = (List<Question>)session.getAttribute("questionsAndAns");
        String url =  "summary.jsp";
        String correctAns = listQ.get(ques_counter).getCorrectAnswer();
        List<String> outcomes = (List<String>)session.getAttribute("outcome");
        
        if (ques_counter < 5) {
            
            
            if (urs_answer.equalsIgnoreCase(correctAns)) {
                
                result = "Correct";
                
            }else{
            
                result="wrong";
                
            }
            
            ques_counter++;
            url = "question_page.jsp";         
            outcomes.add(result);
            
            
        }
        
        
        
               
        
        
        session.setAttribute("ques_counter", ques_counter);
        session.setAttribute("outcome", outcomes);
           
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
        
    }

    

}
