<%@page import="com.secaidastudio.e04_mvc.model.Course" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean
    id="single_course"
    scope="request"
    class="com.secaidastudio.e04_mvc.model.Course"/>

<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Academik | ${single_course.name}"/>
</jsp:include>

<h1>Informacion del curso</h1>

<div class="row">
    <div class="col">Nombre del curso</div>
    <div class="col">${single_course.name}</div>    
</div>

<div class="row">
    <div class="col">Descripcion del curso</div>
    <div class="col">${single_course.description}</div>    
</div>

<div class="row">
    <div class="col">Numero de creditos</div>
    <div class="col">${single_course.credits}</div>    
</div>

<div class="row">
    <a class="btn btn-primary" href="courses/edit?id=${single_course.code}">Editar</a>
    <input class="btn btn-danger" type="submit" form="form-to-delete" value="Eliminar"/>
    <a class="btn btn-secondary" href="../index.html">Cancelar</a>
    <form method="POST" name="form-to-delete" id="form-to-delete">
        <input type="hidden" name="_method" value="DELETE"/>
        <input type="hidden" name="code" value="${single_course.code}"/>
    </form>
</div>

<%@include file="templates/Footer.jsp" %>