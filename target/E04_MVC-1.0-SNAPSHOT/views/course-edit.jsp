<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean
    id="single_course"
    scope="request"
    class="com.secaidastudio.e04_mvc.model.Course"/>
<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Academik | Editar curso"/>
</jsp:include>

<h1>Editar curso</h1>
<form method="POST">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="hidden" name="code" value="${single_course.code}"/>

    <div class="form-group">
        <label for="name">Nombre del curso</label>
        <input class="form-control" type="text" name="name" value="${single_course.name}"/>
    </div>

    <div class="form-group">
        <label for="description">Descripcion del curso</label>
        <input class="form-control" type="text" name="description" value="${single_course.description}"/>
    </div>

    <div class="form-group">
        <label for="credits">Creditos</label>
        <input class="form-control" type="text" name="credits" value="${single_course.credits}"/>
    </div>
    <input class="btn btn-primary" type="submit" value="Guardar"/>
    <a class="btn btn-danger" href="../index.html">Cancelar</a>
</form>

<%@include file="templates/Footer.jsp" %>