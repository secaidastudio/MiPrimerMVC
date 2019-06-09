package com.secaidastudio.e04_mvc.controller;

import com.secaidastudio.e04_mvc.dao.StudentDAO;
import com.secaidastudio.e04_mvc.model.Grade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oscar
 */
@WebServlet("/grades/*")
public class GradeController extends HttpServlet {
    //crear un objeto de tipo gradeDAO
    StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String complement = req.getPathInfo();
        if (complement == null) {
            complement = "";
        }
        System.err.println(complement);
        String redirectPage = null;
        switch(complement){
            case "/grades":
                redirectPage = "grades.jsp";
                break;
            default : 
                resp.sendRedirect(req.getContextPath()+"/students");
        }
        
        //Renderice este JSP
        RequestDispatcher rd = req.getRequestDispatcher(
                "/views/" + redirectPage
        );
        //Adelante con la renderización
        rd.forward(req, resp);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("creating new grade");
        Grade grade = new Grade();
        
        grade.setStudentCode(Integer.parseInt(req.getParameter("students")));
        grade.setCourseCode(Integer.parseInt(req.getParameter("courses")));
        grade.setGrade(Double.parseDouble(req.getParameter("courseGrade")));
        
        dao.grade(grade);
        resp.sendRedirect(req.getContextPath() + "/students");
    }
    
    
    
}
