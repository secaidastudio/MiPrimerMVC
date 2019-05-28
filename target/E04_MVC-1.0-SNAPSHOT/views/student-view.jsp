
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean
    id="single_student"
    scope="request"
    class="com.secaidastudio.e04_mvc.model.Student"/>

<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Academik | ${single_student.fullName}"/>
</jsp:include>

<h1>Informacion del estudiante</h1>

<div class="row">
    <div class="col">Nombres</div>
    <div class="col">${single_student.firstName}</div>
</div>

<div class="row">

    <div class="col">Apellido</div>
    <div class="col">${single_student.lastName}</div>
</div>

<div class="row">    
    <div class="col">Correo electronico</div>
    <div class="col">${single_student.email}</div>
</div>

<div class="row">    
    <div class="col">Fecha de nacimiento</div>
    <div class="col">${single_student.birthday}</div>
</div>

<div class="row">
    <div class="col">Encargado</div>
    <div class="col">${single_student.guardian}</div>
</div>

<div class="row">
    <div class="col">Telefono de contacto</div>
    <div class="col">${single_student.contactPhone}</div>
</div>

<div class="row">
    <a class="btn btn-primary" href="edit?id=${single_student.code}">Editar</a>
</div>

    <%@include file="templates/Footer.jsp" %>