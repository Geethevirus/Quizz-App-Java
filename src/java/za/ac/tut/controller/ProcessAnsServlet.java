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

/**
 *
 * @author ACER
 */
public class ProcessAnsServlet extends HttpServlet {

  
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        String urs_answer = request.getParameter("usrAns");
        int ques_counter = (Integer)session.getAttribute("ques_counter"); 
        String outcome = "";        
        String url =  "summary.jsp";
        List<String> outcomes = (List<String>)session.getAttribute("outcome");
        
        
        if(ques_counter <=5){
            
            List<String> correctAns = (List<String>)session.getAttribute("answers");
            
            if (correctAns.get(ques_counter).equalsIgnoreCase(urs_answer)) {
                
                outcome = "Correct";
                
            }else{
            
                outcome = "wrong";
                
            }
            outcomes.add(outcome);
            url = "question_page.jsp";
            
            
        }else
        {
            
            url = "summary.jsp";
            
        }
        
        ques_counter++;
        session.setAttribute("ques_counter", ques_counter);
        
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
        
    }

    

}
