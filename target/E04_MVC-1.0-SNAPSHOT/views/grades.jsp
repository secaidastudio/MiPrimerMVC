<%@page import="com.secaidastudio.e04_mvc.model.Grade"%>
<%@page import="com.secaidastudio.e04_mvc.model.Course"%>
<%@page import="com.secaidastudio.e04_mvc.model.Student" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Academik | Estudiantes"/>
</jsp:include>

<%
    com.secaidastudio.e04_mvc.dao.StudentDAO dao = new com.secaidastudio.e04_mvc.dao.StudentDAO();
    java.util.List<com.secaidastudio.e04_mvc.model.Student> students = dao.queryAll();

    com.secaidastudio.e04_mvc.dao.CourseDAO daoc = new com.secaidastudio.e04_mvc.dao.CourseDAO();
    java.util.List<com.secaidastudio.e04_mvc.model.Course> courses = daoc.queryAll();

%>
<form method="POST"> 
    <div class="form-row">

        <div class="col">
            <select class="form-control" name="students" >

                <% for (Student s : students) {%>
                <option value="<%= s.getCode()%>"><%= s.getFullName()%></option>

                <%}%>


            </select>
        </div>

        <div class="col">
            <select class="form-control" name="courses" >
                <% for (Course c : courses) {%>
                <option value="<%= c.getCode()%>"><%= c.getName()%></option>
                <%// g.setCourseCode((c.getCode())); %>
                <%}%>
            </select>
        </div>
        <div class="col">
            <label for="courseGrade">Nota</label>
            <input  type="number" min="0" max="100" name="courseGrade" step="0.01"  required /> 
            <input class="btn btn-primary" type="submit" value="crear"/>
        </div>

    </div>   

</form>

<%@include file="templates/Footer.jsp" %>
