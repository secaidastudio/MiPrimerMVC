<%@page import="com.secaidastudio.e04_mvc.dao.StudentDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Nuevo alumno"/>
</jsp:include>
<h1>Nuevo estudiante</h1>
<form method="POST">
    <div class="form-group">
        <label for="firstName">Nombres</label>
        <input class="form-control" type="text" name="firstName"/>
    </div>
    
    <div class="form-group">
        <label for="lastName">Apellidos</label>
        <input class="form-control" type="text" name="lastName"/>
    </div>
    
    <div class="form-group">
        <label for="gender">Genero</label>
        <select class="form-control" name="gender">
            <option value="M">Masculino</option>
            <option value="F">Femenino</option>
        </select>
    </div>
    
    <div class="form-group">
        <label for="email">Correo electronico</label>
        <input class="form-control" type="text" name="email"/>
    </div>
    
    <div class="form-group">
        <label for="birthday">Fecha de nacimiento</label>
        <input class="form-control" type="text" name="birthday"/>
    </div>
    
    <div class="form-group">
        <label for="guardian">Encargado</label>
        <input class="form-control" type="text" name="guardian"/>
    </div>
    
    <div class="form-group">
        <label for="contactPhone">Telefono de contacto</label>
        <input class="form-control" type="text" name="contactPhone"/>
    </div>
    <input class="btn btn-primary" type="submit" value="crear"/>
    <a class="btn btn-danger" href="../index.html">Cancelar</a>
</form>
<%@include file="templates/Footer.jsp" %>

