/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        String stud_name = request.getParameter("user_name");
        
        
        
        QuestionBank q = new QuestionBank();
        
        
        List<String> outcome = new ArrayList<>();
        List<String> stud_answrs = new ArrayList<>();
        List<Question> questionsAndAns = q.getRandom();
        
        int ques_counter = 0;
        int num_correct = 0;
        int num_ques = 5;
        
        session.setAttribute("questionsAndAns", questionsAndAns);
        session.setAttribute("ques_counter", ques_counter);
        session.setAttribute("stud_name", stud_name);
        session.setAttribute("outcome", outcome);
        session.setAttribute("num_ques", num_ques);
        session.setAttribute("num_correct", num_correct);
        session.setAttribute("stud_answrs", stud_answrs);
        
        
        
        RequestDispatcher disp = request.getRequestDispatcher("question_page.jsp");
        disp.forward(request, response);
        
        
        
        
        
        
        
    }

}
