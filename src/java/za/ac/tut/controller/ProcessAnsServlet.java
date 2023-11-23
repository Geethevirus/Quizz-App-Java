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
import za.ac.tut.model.QuestionBank;

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
        QuestionBank q = new QuestionBank();
        int ques_counter = (Integer)session.getAttribute("ques_counter");
        int num_correct = (Integer)session.getAttribute("num_correct");
        
        
        String result = ""; 
        List<Question> listQ = (List<Question>)session.getAttribute("questionsAndAns");
        List<String> stud_answrs = (List<String>)session.getAttribute("stud_answrs");
        String correctAns = "";
        String url =  "summary.jsp";
        String exam_outcome= "";
        double perc = 0;
        
        List<String> outcomes = (List<String>)session.getAttribute("outcome");
        
        
        if (ques_counter < 5) {
            
            correctAns = listQ.get(ques_counter).getCorrectAnswer();
             
            if (urs_answer.equalsIgnoreCase(correctAns)) {
                
                result = "Correct";
                num_correct++;
                
            }else{
            
                result="wrong";
                
            }
            
            
            url = "question_page.jsp";         
            outcomes.add(result);
            stud_answrs.add(urs_answer);
            
        }
        ques_counter++;
        
        if (ques_counter==5) {
            
            url =  "summary.jsp";
            perc = q.getPercentage(num_correct);
            
            if (perc > 50 && perc < 74) {
                
                exam_outcome = "PASS";
                
            }else if(perc >= 74 && perc<=100){
                
                exam_outcome = "PASS WITH DISTINCTION";
                
            }else{
                
                exam_outcome = "FAIL";
            
            }
        }
        

                 
        
        
        session.setAttribute("ques_counter", ques_counter);
        session.setAttribute("outcome", outcomes);
        request.setAttribute("perc", perc);
        request.setAttribute("exam_outcome", exam_outcome);
        session.setAttribute("num_correct",num_correct);
        session.setAttribute("stud_answrs",stud_answrs);
           
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
        
    }

}
