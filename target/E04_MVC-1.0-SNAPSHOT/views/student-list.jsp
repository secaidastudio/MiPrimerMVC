<%@page import="com.secaidastudio.e04_mvc.model.Student" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Academik | Estudiantes"/>
</jsp:include>

<!--
Lo que viene a continuacion es la que declara el objeto list_of_students
que proviene del StudentController.java usando metodo get
-->

<jsp:useBean
    id="list_of_students"
    scope="request"
    class="List<Student>"/>

<table class="table">
    <thead>
        <tr>
            <th>Estudiante</th>
            <th>Correo</th>
            <th>Responsable</th>
            <th>Numero de contacto</th>
        </tr>
    </thead>
    <tbody>
        <% for (Student s : list_of_students) {%>

        <tr>
            <td><%=s.getFullName()%></td>
            <td><%=s.getEmail()%></td>
            <td><%=s.getGuardian()%></td>
            <td><%=s.getContactPhone()%></td>
            <td>
                <a class="btn btn-primary" href="edit?id=<%=s.getCode()%>">Editar</a>
                <a class="btn btn-primary" href="view?id=<%=s.getCode()%>">Ver</a>
            </td>
        </tr>
        <%}%>
    </tbody>
</table>
    
        <%@include file="templates/Footer.jsp" %>
