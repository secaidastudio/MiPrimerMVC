<%@page import="com.secaidastudio.e04_mvc.model.Course" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Academik | Cursos"/>
</jsp:include>

<!--
Lo que viene a continuacion es la que declara el objeto list_of_students
que proviene del StudentController.java usando metodo get
-->

<jsp:useBean
    id="list_of_courses"
    scope="request"
    class="List<Course>"/>

<table class="table">
    <thead>
        <tr>
            <th>Nombre del curso</th>
            <th>Descripcion del curso</th>
            <th>Creditos</th>
        </tr>
    </thead>

    <tbody>
        <% for (Course c : list_of_courses) {%>
        <tr>
            <td><%=c.getName()%></td>
            <td><%=c.getDescription()%></td>
            <td><%=c.getCredits()%></td>
            <td>
                <a class="btn btn-primary" href="courses/edit?id=<%=c.getCode()%>">Editar</a>
                <a class="btn btn-primary" href="courses/view?id=<%=c.getCode()%>">Ver</a>
            </td>
        </tr>      
        <%}%>
    </tbody>
</table>
<div class="container" align="center">
    <a class="btn btn-primary" href="courses/create">Nuevo curso</a>
    <a class="btn btn-primary" href="../index.html">Pagina de inicio</a>
</div>

<%@include file="templates/Footer.jsp" %>