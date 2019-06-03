<%@page import="com.secaidastudio.e04_mvc.dao.CourseDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Nuevo curso"/>
</jsp:include>
<h1>Nuevo curso</h1>
<form method="POST">
    <div class="form-group">
        <label for="courseName">Nombre del curso</label>
        <input class="form-control" type="text" name="courseName" required/>
    </div>
    
    <div class="form-group">
        <label for="courseDesc">Descripcion del curso</label>
        <input class="form-control" type="text" name="courseDesc" required/>
    </div>
    
    <div class="form-group">
        <label for="courseCredits">Numero de creditos</label>
        <input class="form-control" type="number" name="courseCredits" required/>
    </div>
    <input class="btn btn-primary" type="submit" value="crear"/>
    <a class="btn btn-danger" href="../index.html">Cancelar</a>
</form>

<%@include file="templates/Footer.jsp" %>
