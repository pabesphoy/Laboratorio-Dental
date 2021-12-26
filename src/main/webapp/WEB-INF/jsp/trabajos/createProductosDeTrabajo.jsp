<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="EnemiesCards">
    <h2>
		Agregar producto a trabajo
    </h2>
    <form:form method="POST" modelAttribute="trabajosProductos" class="form-horizontal" id="add-owner-form">
        <div class="form-group has-feedback">
            <label for="producto" style="margin-left: 8.75%; margin-top: 1%; margin-bottom: 1%;">Producto</label>
            <select class="form-select" aria-label="Producto" name="producto" style="margin-left: 2.7%; width: 82.7%; font-size: large;">
                <c:forEach items="${productos}" var="producto">
                    <option value="${producto.id}"><c:out value="${producto.nombre}"></c:out></option>
                </c:forEach>
            </select>
            <petclinic:inputField label="Unidades" name="unidades"/>                                 
            <petclinic:inputField label="Precio por unidad" name="precioPorUnidad"/>   
            <petclinic:inputField label="Descuento" name="descuento"/>     
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                  <button class="btn btn-default" type="submit">Enter</button>
            </div>
        </div>
    </form:form>
</petclinic:layout> 