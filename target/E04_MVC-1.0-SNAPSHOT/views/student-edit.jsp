<%@page import="com.secaidastudio.e04_mvc.utils.TimesUtils" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean
    id="single_student"
    scope="request"
    class="com.secaidastudio.e04_mvc.model.Student"/>
<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Academik | Editar Estudiante"/>
</jsp:include>

<h1>Editar estudiante</h1>
<form method="POST">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" name="code" value="${single_student.code}">
    
    <div class="form-group">
        <label for="firstName">Nombres</label>
        <input class="form-control" type="text" name="firstName" value="${single_student.firstName}"/>
    </div>
    
    <div class="form-group">
        <label for="lastName">Apellidos</label>
        <input class="form-control" type="text" name="lastName" value="${single_student.lastName}"/>
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
        <input class="form-control" type="text" name="email" value="${single_student.email}"/>
    </div>
    
    <div class="form-group">
        <label for="birthday">Fecha de nacimiento</label>
        <input class="form-control" type="text" name="birthday" value="${single_student.birthdayAsString}"/>
    </div>
    
    <div class="form-group">
        <label for="guardian">Encargado (a)</label>
        <input class="form-control" type="text" name="guardian" value="${single_student.guardian}"/>
    </div>
    
    <div class="form-group">
        <label for="contactPhone">Telefono de contacto</label>
        <input class="form-control" type="text" name="contactPhone" value="${single_student.contactPhone}"/>
    </div>
    
    <input class="btn btn-primary" type="submit" value="Guardar"/>
        
</form>
    
    <%@include file="templates/Footer.jsp" %>    
