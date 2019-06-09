package com.secaidastudio.e04_mvc.controller;

import com.secaidastudio.e04_mvc.dao.StudentDAO;
import com.secaidastudio.e04_mvc.model.Student;
import com.secaidastudio.e04_mvc.utils.TimesUtils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet("/students/*")
public class StudentController extends HttpServlet {

    //Crear un objeto student DAO
    StudentDAO dao = new StudentDAO();

    /**
     * Determina que "recurso" mostrar al usuario.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String complement = req.getPathInfo();
        if (complement == null) {
            complement = "";
        }
        System.err.println(complement);
        String redirectPage;
        switch (complement) {
            case "/create":
                redirectPage = "student-create.jsp";
                break;
            case "/view":
                //obtener el parametro desde la URL
                long id = Long.parseLong(req.getParameter("id"));
                Student sToView = dao.findById(id);
                req.setAttribute("single_student", sToView);
                redirectPage = "student-view.jsp";
                break;
            case "/edit":
                long idToEdit = Long.parseLong(req.getParameter("id"));
                Student sToEdit = dao.findById(idToEdit);
                req.setAttribute("single_student", sToEdit);
                redirectPage = "student-edit.jsp";

                break;
            
           /* case "/grade":
                redirectPage = "grades.jsp";
                
                break;*/
            case "/list":
            case "/":
            case "":
                List<Student> allStudents = dao.queryAll();
                req.setAttribute("list_of_students", allStudents);
                redirectPage = "student-list.jsp";
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/students");
                return;
        }

        //Renderice este JSP
        RequestDispatcher rd = req.getRequestDispatcher(
                "/views/" + redirectPage
        );
        //Adelante con la renderización
        rd.forward(req, resp);
    }

    /**
     * metodo para obtener los datos que se envian del formulario student-create
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if ("PUT".equals(req.getParameter("_method"))) {
            doPut(req, resp);
            return;
        }

        if ("DELETE".equals(req.getParameter("_method"))) {
            doDelete(req, resp);
            return;
        }
        System.out.println("Creating new student");

        Student student = new Student();

        student.setFirstName(req.getParameter("firstName"));
        student.setLastName(req.getParameter("lastName"));
        student.setGender(req.getParameter("gender"));
        student.setEmail(req.getParameter("email"));
        student.setContactPhone(req.getParameter("contactPhone"));
        student.setGuardian(req.getParameter("guardian"));
        student.setBirthday(TimesUtils.getFromDDMMYYY(req.getParameter("birthday")));

        dao.create(student);
        resp.sendRedirect(req.getContextPath() + "/students");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Editing a student...");

        Student edited = new Student();
        edited.setFirstName(req.getParameter("firstName"));
        edited.setLastName(req.getParameter("lastName"));
        edited.setGender(req.getParameter("gender"));
        edited.setEmail(req.getParameter("email"));
        edited.setContactPhone(req.getParameter("contactPhone"));
        edited.setGuardian(req.getParameter("guardian"));
        edited.setBirthday(TimesUtils.getFromDDMMYYY(req.getParameter("birthday")));

        dao.edit(Integer.parseInt(req.getParameter("code")), edited);
        resp.sendRedirect(req.getContextPath() + "/students");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Deleting student...");
        long id = Long.parseLong(req.getParameter("code"));
        dao.delete(id);
        resp.sendRedirect(req.getContextPath()+"/students");
    }
    
}


