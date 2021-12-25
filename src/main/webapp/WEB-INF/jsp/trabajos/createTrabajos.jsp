<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="EnemiesCards">
    <h2>
		Nuevo trabajo
    </h2>
    <form:form method="POST" modelAttribute="trabajo" class="form-horizontal" id="add-owner-form">
        
        <label for="clinica" style="margin-left: 1.9%; margin-top: 1%;">Clinica/Laboratorio</label>
        <select class="form-select" aria-label="Clinica" name="clinica" style="margin-left: 2.7%; width: 82.7%; font-size: large;">
            <c:forEach items="${clinicas}" var="clinica">
                    <option value="${clinica.id}"><c:out value="${clinica.nombre}"></c:out></option>
            </c:forEach>
        </select>
        <label for="doctor" style="margin-left: 9.4%; margin-top: 1%;">Doctor</label>
        <select class="form-select" aria-label="Doctor" name="doctor" style="margin-left: 2.7%; width: 82.7%; font-size: large;">
            <c:forEach items="${doctores}" var="doctor">
                    <option value="${doctor.id}"><c:out value="${doctor.nombre}"></c:out></option>
            </c:forEach>
        </select>
        <label for="paciente" style="margin-left: 8.4%; margin-top: 1%;">Paciente</label>
        <select class="form-select" aria-label="Paciente" name="paciente" style="margin-left: 2.7%; width: 82.7%; font-size: large;">
            <c:forEach items="${pacientes}" var="paciente">
                    <option value="${paciente.id}"><c:out value="${paciente.nombre}"></c:out></option>
            </c:forEach>
        </select>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                  <button class="btn btn-default" style="margin-top: 6%;" type="submit">Enter</button>
            </div>
        </div>
    </form:form>
</petclinic:layout> 