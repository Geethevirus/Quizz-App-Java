/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ACER
 */
public class QuestionBank {

    public QuestionBank() {
    }
    
    public List<Question> getRandom()
    {
        
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question("1 + 1 = ?" ,"1","11","2","0","2"));
        questions.add(new Question("1 * 1 = ?" ,"1","11","2","0","1"));      
        questions.add(new Question("1 / 1 = ?" ,"1","11","2","0","1"));
        questions.add(new Question("1 - 1 = ?" ,"1","11","2","0","0"));
        questions.add(new Question("1 % 1 = ?" ,"1","11","2","0","0"));
        questions.add(new Question("(1 + 1) *2 = ?" ,"1","2","4","6","4"));
        questions.add(new Question("(1 + 1) / 2 = ? = ?" ,"1","2","4","6","1"));
      
        
        
        
        
//        List<String> questions = new ArrayList<>();
//        
//        questions.add("1 + 1 = ? <br> \n\n"
//                + "A.1\n <br>"
//                + "B.11\n <br>"
//                + "C.2\n <br>"
//                + "D.0\n"
//                +"C");
// 
//        
//          questions.add("1 * 1 = ? <br>\n\n" +
//                "A. 1\n <br>" +
//                "B. 11\n <br>" +
//                "C. 2\n <br>" +
//                "D. 0\n"
//                  + "A");
//         
//        
//        questions.add("1 / 1 = ? <br>\n\n" +
//                "A. 1\n <br>" +
//                "B. 11\n <br>" +
//                "C. 2\n <br>" +
//                "D. 0\n"
//                + "A");
//      
//        
//        questions.add("1 - 1 = ?<br> \n\n" +
//                "A. 1\n <br>" +
//                "B. 11\n <br>" +
//                "C. 2\n <br>" +
//                "D. 0"
//                + "D");
//      
//        
//        questions.add("1 % 1 = ? <br> \n\n" +
//                "A. 1\n <br>" +
//                "B. 11\n <br>" +
//                "C. 2\n <br>" +
//                "D. 0\n"
//                + "D");
//        
//       
//        
//        questions.add("(1 + 1) *2 = ? <br> \n\n" +
//                "A. 1\n <br>" +
//                "B. 2\n <br>" +
//                "C. 4\n <br>" +
//                "D. 6\n"
//                + "C");
//        
//        
//        questions.add("(1 + 1) / 2 = ? <br>\n\n" +
//                "A. 1\n <br>" +
//                "B. 2\n <br>" +
//                "C. 4\n <br>" +
//                "D. 6\n"
//                + "A");
        
        Collections.shuffle(questions);
        
        List<Question> five_questions = questions.subList(0, 5);
        
        return five_questions;
        
    }
    
    public List<String> getAnswers(List<String> questionsAndAns)
    {
        
        List<String> answers = new ArrayList<>();
        
        for (int i = 0; i < questionsAndAns.size(); i++) {
            
            
            answers.add(questionsAndAns.get(i).substring(questionsAndAns.get(i).length()-1));
            
        }
        
        return answers;
        
    }
    public List<String> getQuestions(List<String> questionsAndAns)
    {
        List<String> questions = new ArrayList<>();
        
        for (int i = 0; i < questionsAndAns.size(); i++) {
            
            questions.add(questionsAndAns.get(i).substring(0,questionsAndAns.get(i).length()-1));
            
        }
        return questions;
    }
    
}
