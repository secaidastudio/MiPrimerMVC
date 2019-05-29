package com.secaidastudio.e04_mvc.controller;

import com.secaidastudio.e04_mvc.dao.CourseDAO;
import com.secaidastudio.e04_mvc.model.Course;
import java.io.IOException;
import java.util.List;
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
@WebServlet("/courses/*")
public class CourseController extends HttpServlet {

    //Crear un objeto CourseDAO
    
    CourseDAO dao = new CourseDAO();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String complement = req.getPathInfo();
        if (complement==null) {
            complement="";
        }
        System.err.println(complement);
        String redirectPage;
        switch(complement){
            case "/create":
                redirectPage="course-create.jsp";
                break;
            case "/view":
                int idToView = Integer.parseInt(req.getParameter("id"));
                Course cToView = dao.findById(idToView);
                req.setAttribute("single_course", cToView);
                redirectPage = "course-view.jsp";
                break;
            case "/edit":
                redirectPage="course-edit.jsp";
                break;
            case "/":
            case "":
                List<Course> allCourses = dao.queryAll();
                req.setAttribute("list_of_courses", allCourses);
                redirectPage="course-list.jsp";
                break;
            default:
                resp.sendRedirect(req.getContextPath()+"/courses");
                return;
        }
        RequestDispatcher rd = req.getRequestDispatcher(
                "/views/"+redirectPage
        );
        
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Creating new course");
        Course course = new Course();
        
        course.setName(req.getParameter("courseName"));
        course.setDescription(req.getParameter("courseDesc"));
        course.setCredits(Integer.parseInt(req.getParameter("courseCredits")));
        
        dao.create(course);
        resp.sendRedirect(req.getContextPath()+"/courses");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
