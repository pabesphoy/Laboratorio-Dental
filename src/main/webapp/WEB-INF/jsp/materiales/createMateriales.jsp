<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="EnemiesCards">
    <h2>
		Nuevo material
    </h2>
    <form:form method="POST" modelAttribute="material" class="form-horizontal" id="add-owner-form">
        <div class="form-group has-feedback">
            <petclinic:inputField label="Nombre" name="nombre"/> 
            <petclinic:inputField label="Codigo" name="codigo"/>   
            <petclinic:inputField label="Marca" name="marcaFabricante"/>   
            <petclinic:inputField label="Numero de lote" name="numeroDeLote"/>
            <label for="categoria" style="margin-left: 9%;">Categoria</label>
            <select class="form-select" aria-label="Categoria" name="categoria" style="margin-left: 1.8%; width: 82.7%; font-size: large;">
                <c:forEach items="${categorias}" var="categoria">
                    <option value="${categoria.id}"><c:out value="${categoria.nombre}"></c:out></option>
                </c:forEach>
            </select>                         
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                  <button class="btn btn-default" type="submit">Enter</button>
            </div>
        </div>
    </form:form>
</petclinic:layout> 